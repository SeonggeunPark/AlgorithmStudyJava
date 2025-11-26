SELECT ID, (CASE
                WHEN rnk <= (total*0.25) THEN 'CRITICAL'
                WHEN rnk <= (total*0.5) THEN 'HIGH'
                WHEN rnk <= (total*0.75) THEN 'MEDIUM'
                ELSE 'LOW' 
              END) AS COLONY_NAME
FROM (SELECT 
        ID, 
        ROW_NUMBER() OVER(ORDER BY SIZE_OF_COLONY DESC) AS rnk, 
        COUNT(*) OVER() AS total
FROM ECOLI_DATA) t
ORDER BY ID;