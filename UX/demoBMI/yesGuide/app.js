/**
 * BMI 學生健康體位管理系統 (Nielsen 10 Heuristics 實踐版)
 * 逢甲大學 使用者體驗設計 (gTeachUX) 示範教材
 */

(function () {
  'use strict';

  // 衛福部國民健康署成人 BMI 分級標準與衛教建議
  const BMI_CATEGORIES = [
    {
      key: 'underweight',
      label: '體重過輕',
      min: 0,
      max: 18.5,
      tagClass: 'tag-underweight',
      advice: '體位偏輕，免疫力較弱。建議由蛋白質與天然全穀增加熱量，配合阻力運動增加肌肉量。'
    },
    {
      key: 'normal',
      label: '健康體位',
      min: 18.5,
      max: 24.0,
      tagClass: 'tag-normal',
      advice: '體位非常標準！請持續保持每週至少 150 分鐘中度規律運動與少糖、少鹽的高纖飲食。'
    },
    {
      key: 'overweight',
      label: '體重過重',
      min: 24.0,
      max: 27.0,
      tagClass: 'tag-overweight',
      advice: '體位已略微超標。建議每日減少 300 大卡精緻糖與炸物，增加蔬果比例並維持每日萬步走。'
    },
    {
      key: 'obese-mild',
      label: '輕度肥胖',
      min: 27.0,
      max: 30.0,
      tagClass: 'tag-obese-mild',
      group: 'obese',
      advice: '已進入輕度肥胖區間，糖尿病與心血管風險升高。建議由營養師協助擬定熱量赤字菜單。'
    },
    {
      key: 'obese-mod',
      label: '中度肥胖',
      min: 30.0,
      max: 35.0,
      tagClass: 'tag-obese-mod',
      group: 'obese',
      advice: '慢性病與脂肪肝高風險。建議至家醫科或代謝減重門診進行詳細檢查與生活型態治療。'
    },
    {
      key: 'obese-sev',
      label: '重度肥胖',
      min: 35.0,
      max: Infinity,
      tagClass: 'tag-obese-sev',
      group: 'obese',
      advice: '高健康風險族群。強烈建議尋求專業醫療團隊介入，制定安全性運動與個人化減重方針。'
    }
  ];

  // 判斷體位類別輔助函式
  function getBmiCategory(bmi) {
    for (const cat of BMI_CATEGORIES) {
      if (bmi >= cat.min && bmi < cat.max) {
        return cat;
      }
    }
    return BMI_CATEGORIES[BMI_CATEGORIES.length - 1];
  }

  // 取得所屬大分類 (underweight, normal, overweight, obese)
  function getBmiGroup(bmi) {
    if (bmi < 18.5) return 'underweight';
    if (bmi < 24.0) return 'normal';
    if (bmi < 27.0) return 'overweight';
    return 'obese';
  }

  // DOM 元素快取
  const form = document.getElementById('bmi-form');
  const inputName = document.getElementById('student-name');
  const inputHeight = document.getElementById('student-height');
  const inputWeight = document.getElementById('student-weight');
  const clearNameBtn = document.getElementById('clear-name');

  const errName = document.getElementById('err-name');
  const errHeight = document.getElementById('err-height');
  const errWeight = document.getElementById('err-weight');

  const livePreviewBox = document.getElementById('live-preview-box');
  const previewBmiText = document.getElementById('preview-bmi-text');
  const previewBadgeContainer = document.getElementById('preview-badge-container');

  const btnReset = document.getElementById('btn-reset');
  const btnSampleData = document.getElementById('btn-sample-data');
  const btnExportCsv = document.getElementById('btn-export-csv');
  const btnClearAll = document.getElementById('btn-clear-all');

  // 儀表板元素
  const totalBadge = document.getElementById('total-badge');
  const kpiAvgBmi = document.getElementById('kpi-avg-bmi');
  const kpiAvgStatus = document.getElementById('kpi-avg-status');
  const kpiNormalRate = document.getElementById('kpi-normal-rate');
  const kpiNormalRatio = document.getElementById('kpi-normal-ratio');

  const segUnderweight = document.getElementById('seg-underweight');
  const segNormal = document.getElementById('seg-normal');
  const segOverweight = document.getElementById('seg-overweight');
  const segObese = document.getElementById('seg-obese');

  const countUnderweight = document.getElementById('count-underweight');
  const countNormal = document.getElementById('count-normal');
  const countOverweight = document.getElementById('count-overweight');
  const countObese = document.getElementById('count-obese');
  const countAll = document.getElementById('count-all');

  // 表格與搜尋元素
  const searchInput = document.getElementById('search-input');
  const tableBody = document.getElementById('table-body');
  const shownCount = document.getElementById('shown-count');
  const totalRecordsCount = document.getElementById('total-records-count');
  const legendBtns = document.querySelectorAll('.legend-btn');

  // Modal 元素
  const btnShowHeuristics = document.getElementById('btn-show-heuristics');
  const heuristicsModal = document.getElementById('heuristics-modal');
  const modalClose = document.getElementById('modal-close');
  const btnModalOk = document.getElementById('btn-modal-ok');

  // Toast 容器
  const toastContainer = document.getElementById('toast-container');

  // 應用程式狀態 (State)
  const STORAGE_KEY = 'gDemoUX_yesGuide_students';
  let students = loadStudents();
  let currentFilter = 'all';
  let searchQuery = '';
  let lastDeletedStudent = null;
  let lastDeletedIndex = -1;

  // 初始化
  init();

  function init() {
    bindEvents();
    renderAll();
    inputName.focus();
  }

  // 事件綁定
  function bindEvents() {
    // 即時預覽與清除鍵
    inputName.addEventListener('input', () => {
      clearFieldError(inputName, errName);
      clearNameBtn.style.display = inputName.value.trim() ? 'block' : 'none';
    });

    clearNameBtn.addEventListener('click', () => {
      inputName.value = '';
      clearNameBtn.style.display = 'none';
      inputName.focus();
    });

    inputHeight.addEventListener('input', () => {
      clearFieldError(inputHeight, errHeight);
      checkHeightUnitSmartWarning();
      updateLivePreview();
    });

    inputWeight.addEventListener('input', () => {
      clearFieldError(inputWeight, errWeight);
      updateLivePreview();
    });

    // NS07: 純鍵盤高效連續鍵入 (Enter 流轉)
    inputName.addEventListener('keydown', (e) => {
      if (e.key === 'Enter') {
        e.preventDefault();
        if (validateName()) {
          inputHeight.focus();
          inputHeight.select();
        }
      }
    });

    inputHeight.addEventListener('keydown', (e) => {
      if (e.key === 'Enter') {
        e.preventDefault();
        if (validateHeight()) {
          inputWeight.focus();
          inputWeight.select();
        }
      }
    });

    // 表單送出
    form.addEventListener('submit', (e) => {
      e.preventDefault();
      handleSubmit();
    });

    // 重設按鈕
    btnReset.addEventListener('click', () => {
      resetForm();
      showToast('表單已清空', 'info');
      inputName.focus();
    });

    // 示範資料
    btnSampleData.addEventListener('click', loadSampleData);

    // 匯出 CSV
    btnExportCsv.addEventListener('click', exportCsv);

    // 清空全部記錄
    btnClearAll.addEventListener('click', handleClearAll);

    // 搜尋過濾
    searchInput.addEventListener('input', (e) => {
      searchQuery = e.target.value.trim().toLowerCase();
      renderTable();
    });

    // 分類過濾按鈕
    legendBtns.forEach(btn => {
      btn.addEventListener('click', () => {
        legendBtns.forEach(b => b.classList.remove('active'));
        btn.classList.add('active');
        currentFilter = btn.dataset.filter;
        renderTable();
      });
    });

    // 尼爾森 10 大原則 Modal 控制
    btnShowHeuristics.addEventListener('click', () => {
      heuristicsModal.classList.add('is-active');
      document.body.style.overflow = 'hidden';
    });

    const closeModal = () => {
      heuristicsModal.classList.remove('is-active');
      document.body.style.overflow = '';
    };

    modalClose.addEventListener('click', closeModal);
    btnModalOk.addEventListener('click', closeModal);
    heuristicsModal.addEventListener('click', (e) => {
      if (e.target === heuristicsModal) closeModal();
    });

    window.addEventListener('keydown', (e) => {
      if (e.key === 'Escape' && heuristicsModal.classList.contains('is-active')) {
        closeModal();
      }
    });
  }

  // NS05 & NS09: 欄位驗證與智慧溫馨提醒
  function validateName() {
    const val = inputName.value.trim();
    if (!val) {
      showFieldError(inputName, errName, '⚠️ 請輸入學生姓名');
      return false;
    }
    if (val.length > 20) {
      showFieldError(inputName, errName, '⚠️ 姓名長度請在 20 字以內');
      return false;
    }
    clearFieldError(inputName, errName);
    return true;
  }

  function validateHeight() {
    const val = parseFloat(inputHeight.value);
    if (isNaN(val) || inputHeight.value.trim() === '') {
      showFieldError(inputHeight, errHeight, '⚠️ 請輸入身高（公分 cm）');
      return false;
    }
    // NS05: 單位防呆（若小於 50，研判可能誤輸入公尺 m）
    if (val < 50) {
      if (val > 0 && val < 2.5) {
        showFieldError(inputHeight, errHeight, `💡 提醒：單位是公分(cm)。若是 ${(val * 100).toFixed(0)} cm，請直接填寫整數`);
      } else {
        showFieldError(inputHeight, errHeight, '⚠️ 身高數值不合理（需 ≥ 50 cm）');
      }
      return false;
    }
    if (val > 250) {
      showFieldError(inputHeight, errHeight, '⚠️ 身高請勿超過 250 cm');
      return false;
    }
    clearFieldError(inputHeight, errHeight);
    return true;
  }

  function checkHeightUnitSmartWarning() {
    const val = parseFloat(inputHeight.value);
    if (!isNaN(val) && val > 0 && val <= 2.5) {
      showFieldError(inputHeight, errHeight, `💡 提醒：身高請以公分(cm)填寫（例如：${(val * 100).toFixed(0)}）`, true);
    }
  }

  function validateWeight() {
    const val = parseFloat(inputWeight.value);
    if (isNaN(val) || inputWeight.value.trim() === '') {
      showFieldError(inputWeight, errWeight, '⚠️ 請輸入體重（公斤 kg）');
      return false;
    }
    if (val < 15) {
      showFieldError(inputWeight, errWeight, '⚠️ 體重數值不合理（需 ≥ 15 kg）');
      return false;
    }
    if (val > 300) {
      showFieldError(inputWeight, errWeight, '⚠️ 體重請勿超過 300 kg');
      return false;
    }
    clearFieldError(inputWeight, errWeight);
    return true;
  }

  function showFieldError(inputEl, errorEl, msg, isWarning = false) {
    if (!isWarning) {
      inputEl.classList.add('input-error');
    }
    errorEl.textContent = msg;
    if (isWarning) {
      errorEl.classList.add('warning');
    } else {
      errorEl.classList.remove('warning');
    }
  }

  function clearFieldError(inputEl, errorEl) {
    inputEl.classList.remove('input-error');
    errorEl.textContent = '';
    errorEl.classList.remove('warning');
  }

  // NS01: 即時試算預覽 (Live Preview)
  function updateLivePreview() {
    const h = parseFloat(inputHeight.value);
    const w = parseFloat(inputWeight.value);

    if (!isNaN(h) && h >= 50 && h <= 250 && !isNaN(w) && w >= 15 && w <= 300) {
      const hMeter = h / 100;
      const bmi = w / (hMeter * hMeter);
      const cat = getBmiCategory(bmi);

      livePreviewBox.classList.add('active');
      previewBmiText.innerHTML = `<strong>BMI: ${bmi.toFixed(1)}</strong> <span style="margin-left:6px; color:var(--color-text-muted);">(${cat.label})</span>`;
      previewBadgeContainer.innerHTML = `<span class="tag ${cat.tagClass}">${cat.label}</span>`;
    } else {
      livePreviewBox.classList.remove('active');
      previewBmiText.textContent = '輸入身高與體重即時試算';
      previewBadgeContainer.innerHTML = '';
    }
  }

  // 送出並新增記錄
  function handleSubmit() {
    const isNameOk = validateName();
    const isHeightOk = validateHeight();
    const isWeightOk = validateWeight();

    if (!isNameOk) {
      inputName.focus();
      return;
    }
    if (!isHeightOk) {
      inputHeight.focus();
      return;
    }
    if (!isWeightOk) {
      inputWeight.focus();
      return;
    }

    const name = inputName.value.trim();
    const height = parseFloat(inputHeight.value);
    const weight = parseFloat(inputWeight.value);
    const hMeter = height / 100;
    const bmiVal = weight / (hMeter * hMeter);
    const bmi = parseFloat(bmiVal.toFixed(1));
    const category = getBmiCategory(bmi);

    const newStudent = {
      id: Date.now().toString(36) + Math.random().toString(36).substr(2, 5),
      name,
      height,
      weight,
      bmi,
      categoryKey: category.key,
      categoryLabel: category.label,
      group: getBmiGroup(bmi),
      advice: category.advice,
      createdAt: new Date().toLocaleTimeString('zh-TW', { hour12: false })
    };

    // 新增至清單開頭
    students.unshift(newStudent);
    saveStudents();
    renderAll();

    // NS01: 即時成功反饋
    showToast(`✅ 已新增「${name}」的體檢記錄 (BMI: ${bmi}，${category.label})`, 'success');

    // 清空欄位並「自動回彈聚焦回姓名」，達成 NS07 高速連續輸入
    resetForm();
    inputName.focus();
  }

  function resetForm() {
    form.reset();
    clearNameBtn.style.display = 'none';
    clearFieldError(inputName, errName);
    clearFieldError(inputHeight, errHeight);
    clearFieldError(inputWeight, errWeight);
    updateLivePreview();
  }

  // 渲染所有視圖 (儀表板 + 表格)
  function renderAll() {
    renderDashboard();
    renderTable();
  }

  // NS01 & NS02: 渲染全班儀表板統計
  function renderDashboard() {
    const total = students.length;
    totalBadge.textContent = `${total} 位學生`;
    totalRecordsCount.textContent = total;

    if (total === 0) {
      kpiAvgBmi.textContent = '--';
      kpiAvgStatus.textContent = '尚無記錄';
      kpiNormalRate.textContent = '--%';
      kpiNormalRatio.textContent = '0 / 0 人';

      segUnderweight.style.width = '0%';
      segNormal.style.width = '0%';
      segOverweight.style.width = '0%';
      segObese.style.width = '0%';

      countUnderweight.textContent = '0';
      countNormal.textContent = '0';
      countOverweight.textContent = '0';
      countObese.textContent = '0';
      countAll.textContent = '0';
      return;
    }

    // 計算平均 BMI
    const sumBmi = students.reduce((acc, s) => acc + s.bmi, 0);
    const avgBmi = parseFloat((sumBmi / total).toFixed(1));
    const avgCat = getBmiCategory(avgBmi);

    kpiAvgBmi.textContent = avgBmi.toFixed(1);
    kpiAvgStatus.innerHTML = `<span class="tag ${avgCat.tagClass}" style="font-size:0.75rem;">${avgCat.label}</span>`;

    // 統計各分組人數
    let nUnder = 0, nNorm = 0, nOver = 0, nObese = 0;
    students.forEach(s => {
      const g = s.group || getBmiGroup(s.bmi);
      if (g === 'underweight') nUnder++;
      else if (g === 'normal') nNorm++;
      else if (g === 'overweight') nOver++;
      else if (g === 'obese') nObese++;
    });

    // 健康體位達標率
    const normRate = Math.round((nNorm / total) * 100);
    kpiNormalRate.textContent = `${normRate}%`;
    kpiNormalRatio.textContent = `${nNorm} / ${total} 人`;

    // 分佈長條圖寬度計算
    segUnderweight.style.width = `${(nUnder / total) * 100}%`;
    segNormal.style.width = `${(nNorm / total) * 100}%`;
    segOverweight.style.width = `${(nOver / total) * 100}%`;
    segObese.style.width = `${(nObese / total) * 100}%`;

    // 分類徽章數字
    countUnderweight.textContent = nUnder;
    countNormal.textContent = nNorm;
    countOverweight.textContent = nOver;
    countObese.textContent = nObese;
    countAll.textContent = total;
  }

  // 渲染學生記錄明細表格 (NS06 / NS08)
  function renderTable() {
    let filtered = students.filter(s => {
      // 分組篩選
      if (currentFilter !== 'all') {
        const g = s.group || getBmiGroup(s.bmi);
        if (g !== currentFilter) return false;
      }
      // 搜尋關鍵字
      if (searchQuery) {
        const inName = s.name.toLowerCase().includes(searchQuery);
        const inStatus = s.categoryLabel.toLowerCase().includes(searchQuery);
        if (!inName && !inStatus) return false;
      }
      return true;
    });

    shownCount.textContent = filtered.length;

    if (filtered.length === 0) {
      if (students.length === 0) {
        tableBody.innerHTML = `
          <tr>
            <td colspan="8">
              <div class="empty-state">
                <span class="empty-icon">🌱</span>
                <div class="empty-title">目前尚未建立任何學生體檢記錄</div>
                <p>請使用上方表單鍵入第一筆資料，或點擊「🎲 載入示範資料」立即體驗。</p>
              </div>
            </td>
          </tr>
        `;
      } else {
        tableBody.innerHTML = `
          <tr>
            <td colspan="8">
              <div class="empty-state">
                <span class="empty-icon">🔍</span>
                <div class="empty-title">找不到符合篩選條件的學生</div>
                <p>請嘗試清除搜尋關鍵字或切換「全部」分類標籤。</p>
              </div>
            </td>
          </tr>
        `;
      }
      return;
    }

    tableBody.innerHTML = filtered.map((s, idx) => {
      const cat = getBmiCategory(s.bmi);
      return `
        <tr>
          <td style="color:var(--color-text-subtle); font-weight:600;">${idx + 1}</td>
          <td><strong>${escapeHtml(s.name)}</strong></td>
          <td>${s.height.toFixed(1)}</td>
          <td>${s.weight.toFixed(1)}</td>
          <td><strong style="font-size:1.05rem;">${s.bmi.toFixed(1)}</strong></td>
          <td><span class="tag ${cat.tagClass}">${cat.label}</span></td>
          <td style="font-size:0.84rem; color:var(--color-text-muted); max-width:340px;">${escapeHtml(cat.advice)}</td>
          <td style="text-align: center;">
            <button type="button" class="btn-action-del" data-id="${s.id}" title="NS03: 刪除此筆記錄（支援一鍵 Undo 復原）">
              🗑️ 刪除
            </button>
          </td>
        </tr>
      `;
    }).join('');

    // 綁定行內刪除按鈕
    tableBody.querySelectorAll('.btn-action-del').forEach(btn => {
      btn.addEventListener('click', (e) => {
        const id = e.currentTarget.dataset.id;
        deleteStudent(id);
      });
    });
  }

  // NS03: 自由控制與反悔救援 (Undo Toast)
  function deleteStudent(id) {
    const idx = students.findIndex(s => s.id === id);
    if (idx === -1) return;

    lastDeletedStudent = students[idx];
    lastDeletedIndex = idx;

    students.splice(idx, 1);
    saveStudents();
    renderAll();

    // 觸發帶有 Undo 按鈕的 Toast
    showToast(
      `已刪除學生「${lastDeletedStudent.name}」的體檢記錄`,
      'warning',
      true // 包含 Undo 按鈕
    );
  }

  // 復原刪除 (Undo)
  function undoDelete() {
    if (!lastDeletedStudent) return;

    students.splice(lastDeletedIndex, 0, lastDeletedStudent);
    const restoredName = lastDeletedStudent.name;
    lastDeletedStudent = null;
    lastDeletedIndex = -1;

    saveStudents();
    renderAll();

    showToast(`↩️ 已成功復原學生「${restoredName}」的記錄！`, 'success');
  }

  // 清空所有記錄 (NS03: 附帶二次防呆確認)
  function handleClearAll() {
    if (students.length === 0) {
      showToast('目前清單已經是空的囉！', 'info');
      return;
    }

    const confirmed = window.confirm(`確定要清空全班共 ${students.length} 位學生的體檢資料嗎？\n此動作將清除所有當前記錄。`);
    if (confirmed) {
      students = [];
      saveStudents();
      renderAll();
      showToast('🗑️ 已清空全班記錄', 'info');
    }
  }

  // NS07: 一鍵載入示範資料
  function loadSampleData() {
    const samples = [
      { name: '陳大明', height: 176.0, weight: 68.5 }, // 正常 ~22.1
      { name: '林美麗', height: 162.0, weight: 44.0 }, // 過輕 ~16.8
      { name: '王小虎', height: 180.0, weight: 83.0 }, // 過重 ~25.6
      { name: '張淑芬', height: 158.0, weight: 70.0 }, // 輕度肥胖 ~28.0
      { name: '趙大偉', height: 172.0, weight: 95.0 }, // 中度肥胖 ~32.1
      { name: '孫小美', height: 165.0, weight: 55.0 }  // 正常 ~20.2
    ];

    const newRecords = samples.map((s, i) => {
      const hMeter = s.height / 100;
      const bmiVal = s.weight / (hMeter * hMeter);
      const bmi = parseFloat(bmiVal.toFixed(1));
      const cat = getBmiCategory(bmi);
      return {
        id: Date.now().toString(36) + Math.random().toString(36).substr(2, 5) + i,
        name: s.name,
        height: s.height,
        weight: s.weight,
        bmi,
        categoryKey: cat.key,
        categoryLabel: cat.label,
        group: getBmiGroup(bmi),
        advice: cat.advice,
        createdAt: new Date().toLocaleTimeString('zh-TW', { hour12: false })
      };
    });

    students = [...newRecords, ...students];
    saveStudents();
    renderAll();
    showToast(`🎲 已載入 ${samples.length} 筆經典範例學生資料！`, 'success');
  }

  // NS03: 匯出 CSV
  function exportCsv() {
    if (students.length === 0) {
      showToast('⚠️ 目前尚無學生記錄可供匯出', 'warning');
      return;
    }

    const headers = ['序號', '姓名', '身高(cm)', '體重(kg)', 'BMI', '體位判定', '衛教建議'];
    const rows = students.map((s, idx) => [
      idx + 1,
      `"${s.name.replace(/"/g, '""')}"`,
      s.height.toFixed(1),
      s.weight.toFixed(1),
      s.bmi.toFixed(1),
      `"${s.categoryLabel}"`,
      `"${s.advice.replace(/"/g, '""')}"`
    ]);

    const csvContent = '\uFEFF' + [
      headers.join(','),
      ...rows.map(r => r.join(','))
    ].join('\r\n');

    const blob = new Blob([csvContent], { type: 'text/csv;charset=utf-8;' });
    const url = URL.createObjectURL(blob);
    const link = document.createElement('a');
    link.setAttribute('href', url);
    link.setAttribute('download', `學生體檢BMI紀錄表_${new Date().toISOString().slice(0, 10)}.csv`);
    document.body.appendChild(link);
    link.click();
    document.body.removeChild(link);

    showToast('📥 已成功匯出 CSV 體檢明細表！', 'success');
  }

  // NS01 / NS03: Toast 通知系統
  function showToast(message, type = 'info', hasUndo = false) {
    const toast = document.createElement('div');
    toast.className = `toast toast-${type}`;

    let icon = 'ℹ️';
    if (type === 'success') icon = '✅';
    if (type === 'warning') icon = '⚠️';
    if (type === 'danger') icon = '🚫';

    toast.innerHTML = `
      <div class="toast-content">
        <span class="toast-icon">${icon}</span>
        <span class="toast-msg">${escapeHtml(message)}</span>
      </div>
      <div class="toast-actions">
        ${hasUndo ? '<button type="button" class="toast-undo-btn">復原 (Undo)</button>' : ''}
        <button type="button" class="toast-close-btn" title="關閉">✕</button>
      </div>
    `;

    toastContainer.appendChild(toast);

    const closeToast = () => {
      toast.style.opacity = '0';
      toast.style.transform = 'translateX(100%)';
      setTimeout(() => {
        if (toast.parentNode) toast.parentNode.removeChild(toast);
      }, 250);
    };

    toast.querySelector('.toast-close-btn').addEventListener('click', closeToast);

    if (hasUndo) {
      toast.querySelector('.toast-undo-btn').addEventListener('click', () => {
        undoDelete();
        closeToast();
      });
    }

    // 6 秒後自動淡出
    setTimeout(closeToast, 6000);
  }

  // LocalStorage 操作
  function loadStudents() {
    try {
      const data = localStorage.getItem(STORAGE_KEY);
      return data ? JSON.parse(data) : [];
    } catch (e) {
      console.warn('無法讀取 LocalStorage 資料', e);
      return [];
    }
  }

  function saveStudents() {
    try {
      localStorage.setItem(STORAGE_KEY, JSON.stringify(students));
    } catch (e) {
      console.warn('無法儲存至 LocalStorage', e);
    }
  }

  // XSS 防護
  function escapeHtml(str) {
    if (!str) return '';
    return String(str)
      .replace(/&/g, '&amp;')
      .replace(/</g, '&lt;')
      .replace(/>/g, '&gt;')
      .replace(/"/g, '&quot;')
      .replace(/'/g, '&#039;');
  }

})();
