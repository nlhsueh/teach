/**
 * 學生 BMI 計算與分析系統
 * 連續快速輸入、即時計算、體位分析與班級統計
 */

(function() {
  'use strict';

  // 儲存所有學生資料
  let students = [];

  // DOM 元素引用
  const form = document.getElementById('bmi-form');
  const nameInput = document.getElementById('student-name');
  const heightInput = document.getElementById('student-height');
  const weightInput = document.getElementById('student-weight');
  const formError = document.getElementById('form-error');
  const resetBtn = document.getElementById('btn-reset');
  const tableBody = document.getElementById('bmi-table-body');
  const sampleBtn = document.getElementById('btn-sample');
  const clearAllBtn = document.getElementById('btn-clear-all');

  // 統計元素
  const statCountBadge = document.getElementById('stat-count-badge');
  const statAvgBmi = document.getElementById('stat-avg-bmi');
  const statAvgStatus = document.getElementById('stat-avg-status');
  const statNormalRate = document.getElementById('stat-normal-rate');
  const statNormalCount = document.getElementById('stat-normal-count');
  
  const barUnderweight = document.getElementById('bar-underweight');
  const barNormal = document.getElementById('bar-normal');
  const barOverweight = document.getElementById('bar-overweight');
  const barObese = document.getElementById('bar-obese');

  const countUnderweight = document.getElementById('count-underweight');
  const countNormal = document.getElementById('count-normal');
  const countOverweight = document.getElementById('count-overweight');
  const countObese = document.getElementById('count-obese');

  /**
   * 依據衛福部標準計算 BMI 並分析健康狀態
   * @param {number} heightCm 身高 (公分)
   * @param {number} weightKg 體重 (公斤)
   */
  function analyzeBMI(heightCm, weightKg) {
    const heightM = heightCm / 100;
    const bmi = +(weightKg / (heightM * heightM)).toFixed(1);

    let status = '';
    let tagClass = '';
    let category = ''; // 用於統計分組
    let advice = '';

    if (bmi < 18.5) {
      status = '體重過輕';
      tagClass = 'tag-underweight';
      category = 'underweight';
      advice = '建議均衡攝取六大類營養，可適度搭配肌力運動增加體重。';
    } else if (bmi < 24.0) {
      status = '健康體位';
      tagClass = 'tag-normal';
      category = 'normal';
      advice = '恭喜！請繼續維持健康飲食與每週 150 分鐘以上規律運動習慣。';
    } else if (bmi < 27.0) {
      status = '體重過重';
      tagClass = 'tag-overweight';
      category = 'overweight';
      advice = '建議微調飲食熱量結構，少喝含糖飲料，加強有氧運動。';
    } else if (bmi < 30.0) {
      status = '輕度肥胖';
      tagClass = 'tag-obese-mild';
      category = 'obese';
      advice = '建議擬定體重控制計畫，定時定量飲食並尋求校內健康衛教諮詢。';
    } else if (bmi < 35.0) {
      status = '中度肥胖';
      tagClass = 'tag-obese-mod';
      category = 'obese';
      advice = '建議尋求專業醫師與營養師指導，積極減重以降低心血管代謝風險。';
    } else {
      status = '重度肥胖';
      tagClass = 'tag-obese-sev';
      category = 'obese';
      advice = '建議至醫療院所減重門診進行詳細檢查與全方位健康管理。';
    }

    return { bmi, status, tagClass, category, advice };
  }

  /**
   * 顯示表單錯誤提示
   */
  function showError(msg) {
    formError.textContent = msg;
    formError.style.display = 'block';
  }

  /**
   * 清除表單錯誤提示
   */
  function clearError() {
    formError.textContent = '';
    formError.style.display = 'none';
  }

  /**
   * 表單送出處理（計算、新增、更新與連續輸入）
   */
  function handleFormSubmit(e) {
    e.preventDefault();
    clearError();

    const name = nameInput.value.trim();
    const height = parseFloat(heightInput.value);
    const weight = parseFloat(weightInput.value);

    // 驗證輸入內容
    if (!name) {
      showError('請輸入學生姓名！');
      nameInput.focus();
      return;
    }

    if (isNaN(height) || height < 50 || height > 250) {
      showError('身高數值異常，請輸入介於 50 ~ 250 公分的合理數值！');
      heightInput.focus();
      return;
    }

    if (isNaN(weight) || weight < 15 || weight > 300) {
      showError('體重數值異常，請輸入介於 15 ~ 300 公斤的合理數值！');
      weightInput.focus();
      return;
    }

    // 計算分析
    const analysis = analyzeBMI(height, weight);

    const studentRecord = {
      id: Date.now() + Math.random().toString(36).substr(2, 4),
      name,
      height,
      weight,
      bmi: analysis.bmi,
      status: analysis.status,
      tagClass: analysis.tagClass,
      category: analysis.category,
      advice: analysis.advice
    };

    // 加入清單頂部（最新輸入排在前面）
    students.unshift(studentRecord);
    saveToStorage();
    renderTable();
    updateStatistics();

    // 清空表單並立刻自動聚焦姓名欄位，方便連續鍵入下一位學生
    form.reset();
    nameInput.focus();
  }

  /**
   * 刪除指定記錄
   */
  function deleteRecord(id) {
    students = students.filter(s => s.id !== id);
    saveToStorage();
    renderTable();
    updateStatistics();
  }

  /**
   * 渲染學生表格
   */
  function renderTable() {
    if (students.length === 0) {
      tableBody.innerHTML = `
        <tr id="empty-row">
          <td colspan="8" class="empty-state">
            <div class="empty-icon">📋</div>
            <div class="empty-text">目前尚無記錄</div>
            <div class="empty-sub">請在上方表單輸入學生資料，或點擊「載入範例資料」進行測試</div>
          </td>
        </tr>
      `;
      return;
    }

    let html = '';
    students.forEach((s, idx) => {
      html += `
        <tr>
          <td><span style="font-family: monospace; font-weight: 700; color: #64748b;">#${students.length - idx}</span></td>
          <td><strong>${escapeHtml(s.name)}</strong></td>
          <td>${s.height.toFixed(1)}</td>
          <td>${s.weight.toFixed(1)}</td>
          <td><span class="bmi-val">${s.bmi.toFixed(1)}</span></td>
          <td><span class="tag ${s.tagClass}">${s.status}</span></td>
          <td style="font-size: 13px; color: #475569;">${s.advice}</td>
          <td style="text-align: center;">
            <button type="button" class="btn-sm-del" data-id="${s.id}" title="刪除此筆記錄">刪除</button>
          </td>
        </tr>
      `;
    });

    tableBody.innerHTML = html;

    // 綁定所有刪除按鈕
    tableBody.querySelectorAll('.btn-sm-del').forEach(btn => {
      btn.addEventListener('click', function() {
        const id = this.dataset.id;
        deleteRecord(id);
      });
    });
  }

  /**
   * 更新統計面板
   */
  function updateStatistics() {
    const total = students.length;
    statCountBadge.textContent = `${total} 人`;

    if (total === 0) {
      statAvgBmi.textContent = '--';
      statAvgStatus.textContent = '尚無資料';
      statNormalRate.textContent = '--%';
      statNormalCount.textContent = '0 / 0 人';

      barUnderweight.style.width = '0%';
      barNormal.style.width = '0%';
      barOverweight.style.width = '0%';
      barObese.style.width = '0%';

      countUnderweight.textContent = '0 人';
      countNormal.textContent = '0 人';
      countOverweight.textContent = '0 人';
      countObese.textContent = '0 人';
      return;
    }

    // 計算平均 BMI
    const sumBmi = students.reduce((acc, cur) => acc + cur.bmi, 0);
    const avgBmi = +(sumBmi / total).toFixed(1);
    statAvgBmi.textContent = avgBmi.toFixed(1);

    const avgAnalysis = analyzeBMI(170, (avgBmi * 1.7 * 1.7));
    statAvgStatus.innerHTML = `平均體位：<strong style="color: #1e3a8a;">${avgAnalysis.status}</strong>`;

    // 統計各分類人數
    let nUnderweight = 0;
    let nNormal = 0;
    let nOverweight = 0;
    let nObese = 0;

    students.forEach(s => {
      if (s.category === 'underweight') nUnderweight++;
      else if (s.category === 'normal') nNormal++;
      else if (s.category === 'overweight') nOverweight++;
      else if (s.category === 'obese') nObese++;
    });

    // 正常體位比例
    const normalRate = Math.round((nNormal / total) * 100);
    statNormalRate.textContent = `${normalRate}%`;
    statNormalCount.textContent = `${nNormal} / ${total} 人`;

    // 分佈進度條百分比
    barUnderweight.style.width = `${(nUnderweight / total) * 100}%`;
    barNormal.style.width = `${(nNormal / total) * 100}%`;
    barOverweight.style.width = `${(nOverweight / total) * 100}%`;
    barObese.style.width = `${(nObese / total) * 100}%`;

    countUnderweight.textContent = `${nUnderweight} 人`;
    countNormal.textContent = `${nNormal} 人`;
    countOverweight.textContent = `${nOverweight} 人`;
    countObese.textContent = `${nObese} 人`;
  }

  /**
   * 載入範例測試資料
   */
  function loadSampleData() {
    const samples = [
      { name: '林冠宇', height: 175, weight: 68 },
      { name: '陳雅婷', height: 160, weight: 46 },
      { name: '張家瑋', height: 180, weight: 85 },
      { name: '黃怡君', height: 158, weight: 52 },
      { name: '李俊毅', height: 172, weight: 92 },
      { name: '趙育德', height: 168, weight: 60 }
    ];

    samples.forEach(s => {
      const a = analyzeBMI(s.height, s.weight);
      students.push({
        id: Date.now() + Math.random().toString(36).substr(2, 6),
        name: s.name,
        height: s.height,
        weight: s.weight,
        bmi: a.bmi,
        status: a.status,
        tagClass: a.tagClass,
        category: a.category,
        advice: a.advice
      });
    });

    saveToStorage();
    renderTable();
    updateStatistics();
    nameInput.focus();
  }

  /**
   * 清空所有記錄
   */
  function clearAllRecords() {
    if (students.length === 0) return;
    if (confirm('確定要清空所有已輸入的學生 BMI 記錄嗎？')) {
      students = [];
      saveToStorage();
      renderTable();
      updateStatistics();
      nameInput.focus();
    }
  }

  /**
   * 本地儲存
   */
  function saveToStorage() {
    try {
      localStorage.setItem('bmi_students_no_guide', JSON.stringify(students));
    } catch (e) {
      console.warn('LocalStorage save failed:', e);
    }
  }

  function loadFromStorage() {
    try {
      const data = localStorage.getItem('bmi_students_no_guide');
      if (data) {
        students = JSON.parse(data);
      }
    } catch (e) {
      students = [];
    }
  }

  function escapeHtml(text) {
    const div = document.createElement('div');
    div.textContent = text;
    return div.innerHTML;
  }

  // 事件綁定
  form.addEventListener('submit', handleFormSubmit);

  resetBtn.addEventListener('click', function() {
    form.reset();
    clearError();
    nameInput.focus();
  });

  sampleBtn.addEventListener('click', loadSampleData);
  clearAllBtn.addEventListener('click', clearAllRecords);

  // 初始化
  loadFromStorage();
  renderTable();
  updateStatistics();
  nameInput.focus();
})();
