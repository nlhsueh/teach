package u05_pbtest;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 簡易文章搜尋引擎 (供 Unit 5.9 變質測試 Metamorphic Testing 示範)
 */
public class MetamorphicSearch {

    private final List<String> documents = new ArrayList<>();

    public void addDocument(String doc) {
        if (doc != null) {
            documents.add(doc);
        }
    }

    /**
     * 關鍵字搜尋
     */
    public List<String> search(String query) {
        if (query == null || query.trim().isEmpty()) {
            return Collections.emptyList();
        }

        String clean = query.trim().toLowerCase();
        return documents.stream()
                .filter(doc -> doc.toLowerCase().contains(clean))
                .collect(Collectors.toList());
    }
}
