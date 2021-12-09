package com.test;

public class ClearQuotes {
    public static void main(String[] args) {
        String s = "SELECT hotel_id, hotel_chain_id \n" +
                "  FROM (  SELECT g0.hotel_id, hotel_chain_id \n" +
                "            FROM HOTELS g0\n" +
                "                 INNER JOIN\n" +
                "                 (SELECT 1 AS group_order, hotel_id, 0 AS timestamp\n" +
                "                    FROM HOTEL_ADMIN_MAP\n" +
                "                   WHERE user_id = :userId AND is_hotel_admin IN (1, 2)\n" +
                "                  UNION\n" +
                "                  SELECT 2, hotel_id, 0\n" +
                "                    FROM groups t1 LEFT JOIN group_admin_map t0 ON t0.GROUP_ID = t1.GROUP_ID\n" +
                "                   WHERE     t1.GROUP_ID != 2000000\n" +
                "                         AND LOWER (t1.name) != 'suspended'\n" +
                "                         AND t1.hotel_id IS NOT NULL\n" +
                "                         AND t0.user_id = :userId \n" +
                "                  UNION\n" +
                "                  SELECT 4, hotel_id, 0\n" +
                "                    FROM groups t1 LEFT JOIN group_admin_map t0 ON t0.GROUP_ID = t1.GROUP_ID\n" +
                "                   WHERE     t1.GROUP_ID != 2000000\n" +
                "                         AND LOWER (t1.name) != 'suspended'\n" +
                "                         AND t1.hotel_id IS NOT NULL\n" +
                "                         AND t1.creator_id = :userId \n" +
                "                  UNION\n" +
                "                  SELECT 8, hotel_id, 0\n" +
                "                    FROM HOTEL_ADMIN_MAP\n" +
                "                   WHERE user_id = :userId AND (is_hotel_admin IS NULL OR is_hotel_admin = 0)\n" +
                "                  UNION\n" +
                "                  SELECT 16, t1.hotel_id, 0\n" +
                "                    FROM group_user_map t0, groups t1\n" +
                "                   WHERE     t0.GROUP_ID = t1.GROUP_ID\n" +
                "                         AND t1.GROUP_ID != 2000000\n" +
                "                         AND LOWER (t1.name) != 'suspended'\n" +
                "                         AND t1.hotel_id IS NOT NULL\n" +
                "                         AND t0.user_id = :userId \n" +
                "                  UNION\n" +
                "                  SELECT 32, t1.hotel_id, 0\n" +
                "                    FROM HOTEL_CHAIN_ADMIN_MAP t0, hotels t1\n" +
                "                   WHERE t0.hotel_chain_id = t1.hotel_chain_id AND t0.user_id = :userId) g1\n" +
                "                    ON g0.hotel_id = g1.hotel_id\n" +
                "        ORDER BY g1.group_order)\n" +
                " WHERE ROWNUM = 1";
        System.out.println(s.replace(":userId", "1000299261"));
    }
}
