package com.test;

public class StringTest {
    public static void main(String[] args) {
        String s = "SELECT word_id, voc_type, create_date, max_create_date\n" +
                "  FROM (  \n" +
                "        SELECT u1.word_id, u1.voc_type,\n" +
                "               MAX (u1.create_date) AS create_date,\n" +
                "               MAX (MAX (u1.create_date)) OVER (PARTITION BY u1.const) AS max_create_date\n" +
                "          FROM (\n" +
                "                SELECT 1 AS const, t1.word_id, 'f' AS voc_type, \n" +
                "                       ((t1.create_date - TO_DATE ('1970-01-01', 'yyyy-mm-dd')) * 86400000) AS create_date \n" +
                "                  FROM voc_user_map t1\n" +
                "                       LEFT JOIN lesson_vocabulary t2 ON TO_NUMBER (SUBSTR (t1.word_id, 4)) = t2.id\n" +
                "                       LEFT JOIN voc_family t3 ON t2.family = t3.id\n" +
                "                 WHERE t1.user_id = :userId AND ASCII (t1.word_id) = 118 AND NVL (t1.feature_id, 6) = :featureId \n" +
                "                       AND t3.teach_language = :targetLang\n" +
                "                 UNION ALL\n" +
                "                SELECT 1 AS const, x1.word_id, 'p' AS voc_type, x1.create_date \n" +
                "                  FROM (  \n" +
                "                        SELECT t1.word_id,\n" +
                "                               MAX (t1.creationtime) AS create_date,\n" +
                "                               ROW_NUMBER () OVER (ORDER BY MAX (t1.creationtime) DESC) rw\n" +
                "                          FROM problem_observations t1\n" +
                "                               LEFT JOIN agg_lesson_group_lesson_map t4 ON t1.lesson_id = t4.lesson_id\n" +
                "                               LEFT JOIN unit_lesson_group_map t5 ON t4.lesson_group_id = t5.lesson_group_id\n" +
                "                               LEFT JOIN package_unit_map t6 ON t5.unit_id = t6.unit_id\n" +
                "                               LEFT JOIN prod_categories_packages_map t7 ON t6.package_id = t7.package_id\n" +
                "                               LEFT JOIN prod_categories t8 ON t7.category_id = t8.category_id\n" +
                "                         WHERE     TYPE IN ('w', 'e') AND t1.reserved_user_id = :userId \n" +
                "                               AND creationtime > ((SYSDATE - 180) - TO_DATE ('19700101080000', 'yyyymmddhh24miss')) * (86400000)\n" +
                "                               AND NVL(t8.feature_package_id, 6) = :featureId AND t1.teach_locale = :targetLang\n" +
                "                      GROUP BY t1.word_id ) x1\n" +
                "                 WHERE x1.rw <= 100) u1\n" +
                "      GROUP BY word_id, voc_type, const) g1\n" +
                "  WHERE max_create_date > :lastUpdate \n" +
                "  ORDER BY g1.voc_type, g1.create_date";
        System.out.println(s.replace("\"", ""));
    }
}