-- 코드를 입력하세요
SELECT ANIMAL_TYPE, COUNT(*) AS count
FROM ANIMAL_INS
GROUP BY ANIMAL_TYPE
ORDER BY
    CASE WHEN ANIMAL_TYPE = 'Cat' THEN 1 ELSE 2 END,
    ANIMAL_TYPE ASC;