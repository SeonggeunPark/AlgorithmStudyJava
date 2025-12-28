SELECT t2.GRADE, t1.ID, t1.EMAIL
FROM DEVELOPERS t1
JOIN (SELECT (CASE WHEN ID IN (
                            SELECT d.ID
                            FROM DEVELOPERS d
                            WHERE d.SKILL_CODE & (SELECT SUM(CODE) FROM SKILLCODES WHERE CATEGORY = 'Front End') > 0 
                            AND d.SKILL_CODE & (SELECT SUM(CODE) FROM SKILLCODES WHERE NAME = 'Python') > 0
                        )
            THEN 'A'
            WHEN ID IN (
                            SELECT d.ID
                            FROM DEVELOPERS d
                            WHERE d.SKILL_CODE & (SELECT SUM(CODE) FROM SKILLCODES WHERE NAME = 'C#') > 0 
                        )
            THEN 'B'
            WHEN ID IN (
                            SELECT d.ID
                            FROM DEVELOPERS d
                            WHERE d.SKILL_CODE & (SELECT SUM(CODE) FROM SKILLCODES WHERE CATEGORY = 'Front End') > 0 
                        )
            THEN 'C'
        END
        ) AS GRADE,
        ID
FROM DEVELOPERS) t2 ON t1.ID=t2.ID
WHERE t2.GRADE IS NOT NULL
ORDER BY t2.GRADE, t1.ID;
