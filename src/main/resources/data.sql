INSERT INTO Users( NAME, MAIL, PASSWORD, ROLE, CREATE_DATE)
VALUES
('admin', 'a@a', '$2a$10$FE8mryX8hGGRq3OMjQLdU.TmQbwnizW5bVtFUXaca6A1hJ/hShiPm', '1', '20250601'),
('public', 'p@p', '$2a$10$CZEtRdHVdQWs6e1EWrJmZuBi9rqSNO6TlDTyNrb2Wg.q5sDSRSzmW', '2', '20250601'),
('test90', 't@t', '$2a$10$/ZJWuVT/MYAlX5qNeFpVoehG5JHfNVZ.z2K7JQp7k1ynDGYne5MBC', '2', '20250601');

INSERT INTO Traffic(USER_ID, DATEOFUSE, MEANS, SECTOR, ROAD, COST)
	VALUES
	(1, '2025-04-01', '山手線', '渋谷から新宿', '1', 300),
	(1, '2025-04-04', 'test', 'adminのデータ', '1', 230),
	(3, '2025-04-04', 'test', '2人目のpublicのデータ', '1', 230),
	(2, '2025-05-01', '中央線', '中野から新宿', '1', 160),
	(2, '2025-06-01', '京王井の頭線', '渋谷から吉祥寺', '2', 230),
	(2, '2025-06-11', 'test', 'test', '2', 230),
	(2, '2025-06-11', 'test', 'test', '2', 230),
	(2, '2025-07-11', 'test', 'test', '2', 230),
	(2, '2025-06-21', 'test', 'test', '2', 230),
	(2, '2025-01-11', 'test', 'test', '2', 230),
	(2, '2025-02-11', 'test', 'test', '2', 230),
	(2, '2025-02-22', 'test', 'test', '2', 230),
	(2, '2025-03-21', 'test', 'test', '2', 230),
	(2, '2025-03-31', 'test', 'test', '2', 230),
	(2, '2025-03-11', 'test', 'test', '2', 230),
	(2, '2025-04-01', 'test', 'test', '2', 230),
	(2, '2025-04-02', 'test', 'test', '2', 230),
	(2, '2025-04-03', 'test', 'test', '2', 230),
	(2, '2025-04-04', 'test', 'test', '2', 230),
	(2, '2025-06-11', 'test', 'test', '1', 230);