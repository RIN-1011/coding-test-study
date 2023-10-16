select u.user_id as 'USER_ID', u.nickname as 'NICKNAME', SUM(b.price) as 'TOTAL_SALES' 
from USED_GOODS_BOARD b 
INNER JOIN USED_GOODS_USER u 
ON b.writer_id = u.user_id 
WHERE b.status='DONE' 
group by u.user_id Having TOTAL_SALES >= 700000
order by TOTAL_SALES ASC;