select ITEM_ID, ITEM_NAME, RARITY
from ITEM_INFO
where ITEM_ID IN (select p.ITEM_ID
                from ITEM_TREE c
                right join ITEM_TREE p on c.PARENT_ITEM_ID = p.ITEM_ID
                where c.ITEM_ID is null)
order by ITEM_ID desc;