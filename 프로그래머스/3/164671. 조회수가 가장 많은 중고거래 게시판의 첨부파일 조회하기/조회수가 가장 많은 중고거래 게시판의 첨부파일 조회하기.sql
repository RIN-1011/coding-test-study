select concat('/home/grep/src/', f.board_id, '/', f.file_id, f.file_name, f.file_ext) as FILE_PATH 
from (select board_id from USED_GOODS_BOARD order by views desc limit 1) b join USED_GOODS_FILE f 
on b.board_id=f.board_id
order by f.file_id desc;