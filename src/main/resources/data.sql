INSERT INTO Users( NAME, MAIL, PASSWORD, ROLE, CREATE_DATE)
VALUES
('admin', 'a@a', 'pass1', '1', '20250601'),
('public', 'b@b', 'pass1', '2', '20250601');

INSERT INTO Traffic(USER_ID, DATEOFUSE, MEANS, SECTOR, ROAD, COST)
	VALUES
	(1, '2025-04-01', '通勤', '渋谷から新宿', '1', 300),
	(2, '2025-04-01', '通勤', '渋谷から新宿', '1', 300),
	(2, '2025-04-01', '通勤', '渋谷から新宿', '1', 300);