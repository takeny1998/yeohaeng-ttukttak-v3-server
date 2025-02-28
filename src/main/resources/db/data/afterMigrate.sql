SET foreign_key_checks = 0;
TRUNCATE TABLE place;
TRUNCATE TABLE visit;
TRUNCATE TABLE image;
TRUNCATE TABLE place_image;
SET foreign_key_checks = 1;

INSERT INTO
    place (id, name, category, longitude, latitude, level1, level2, level3, level4)
VALUES
    (1, '청주 자연공원', 'nature', 127.4895, 36.6413, 43, 111, 000, 00),
    (2, '청주 박물관', 'culture', 127.4885, 36.6403, 43, 111, 000, 00),
    (3, '청주 성안길', 'tourism', 127.4905, 36.6423, 43, 111, 000, 00),
    (4, '청주 고인돌 공원', 'nature', 127.4909, 36.6285, 43, 112, 000, 00),
    (5, '청주 시립미술관', 'culture', 127.4919, 36.6295, 43, 112, 000, 00),
    (6, '청주 우암산', 'nature', 127.4899, 36.6275, 43, 112, 000, 00),
    (7, '청주 알밤마을', 'tourism', 127.4547, 36.6347, 43, 113, 000, 00),
    (8, '청주 국립도서관', 'culture', 127.4557, 36.6357, 43, 113, 000, 00),
    (9, '청주 타임월드', 'commerce', 127.4537, 36.6337, 43, 113, 000, 00),
    (10, '청주 수암골', 'nature', 127.4920, 36.6408, 43, 111, 000, 00),
    (11, '청주 청남대', 'tourism', 127.4900, 36.6290, 43, 112, 000, 00),
    (12, '청주 중앙공원', 'nature', 127.4565, 36.6355, 43, 113, 000, 00),
    (13, '청주 모충공원', 'nature', 127.4870, 36.6410, 43, 111, 000, 00),
    (14, '청주 상당도서관', 'culture', 127.4920, 36.6270, 43, 112, 000, 00),
    (15, '청주 버스터미널', 'transport', 127.4550, 36.6340, 43, 113, 000, 00),
    (16, '청주 오송역', 'transport', 127.4890, 36.6420, 43, 111, 000, 00),
    (17, '청주 시외버스터미널', 'transport', 127.4915, 36.6280, 43, 112, 000, 00),
    (18, '청주 농업기술센터', 'commerce', 127.4540, 36.6350, 43, 113, 000, 00),
    (19, '청주 대학교', 'culture', 127.4902, 36.6415, 43, 111, 011, 00),
    (20, '청주 푸른도시', 'dining', 127.4905, 36.6292, 43, 112, 000, 00);

INSERT INTO
    visit (id, visited_on, rating, place_id)
VALUES
    (1, '2023-10-01', 4.5, 1),
    (2, '2023-10-02', 3.0, 1),
    (3, '2023-10-03', 5.0, 2),
    (4, '2023-10-04', 2.5, 2),
    (5, '2023-10-05', 4.0, 2),
    (6, '2023-10-06', 3.5, 3),
    (7, '2023-10-07', 4.8, 4),
    (8, '2023-10-08', 4.0, 4),
    (9, '2023-10-09', 3.0, 5),
    (10, '2023-10-10', 2.0, 6),
    (11, '2023-10-11', 5.0, 6),
    (12, '2023-10-12', 3.2, 7),
    (13, '2023-10-13', 4.1, 8),
    (14, '2023-10-14', 4.6, 8),
    (15, '2023-10-15', 2.8, 9),
    (16, '2023-10-16', 3.9, 10),
    (17, '2023-10-17', 4.2, 11),
    (18, '2023-10-18', 5.0, 12),
    (19, '2023-10-19', 1.5, 13),
    (20, '2023-10-20', 4.7, 14),
    (21, '2023-10-21', 2.9, 15),
    (22, '2023-10-22', 4.8, 16),
    (23, '2023-10-23', 5.0, 17),
    (24, '2023-10-24', 3.1, 18),
    (25, '2023-10-25', 2.2, 19),
    (26, '2023-10-26', 4.0, 20),
    (27, '2023-10-27', 4.5, 1),
    (28, '2023-10-28', 1.0, 2),
    (29, '2023-10-29', 4.9, 3),
    (30, '2023-10-30', 4.1, 4),
    (31, '2023-10-31', 2.8, 5),
    (32, '2023-11-01', 5.0, 6),
    (33, '2023-11-02', 4.6, 7),
    (34, '2023-11-03', 4.7, 8),
    (35, '2023-11-04', 2.9, 9),
    (36, '2023-11-05', 1.8, 10),
    (37, '2023-11-06', 4.2, 11),
    (38, '2023-11-07', 1.7, 12),
    (39, '2023-11-08', 5.0, 13),
    (40, '2023-11-09', 3.6, 14);

INSERT INTO
    image (id, url)
VALUES
    (1, '1.jpg'),
    (2, '2.jpg'),
    (3, '3.jpg'),
    (4, '4.jpg'),
    (5, '5.jpg'),
    (6, '6.jpg'),
    (7, '7.jpg'),
    (8, '8.jpg'),
    (9, '9.jpg'),
    (10, '10.jpg'),
    (11, '11.jpg'),
    (12, '12.jpg'),
    (13, '13.jpg'),
    (14, '14.jpg'),
    (15, '15.jpg'),
    (16, '16.jpg'),
    (17, '17.jpg'),
    (18, '18.jpg'),
    (19, '19.jpg'),
    (20, '20.jpg'),
    (21, '21.jpg'),
    (22, '22.jpg'),
    (23, '23.jpg'),
    (24, '24.jpg'),
    (25, '25.jpg'),
    (26, '26.jpg'),
    (27, '27.jpg'),
    (28, '28.jpg'),
    (29, '29.jpg'),
    (30, '30.jpg'),
    (31, '31.jpg'),
    (32, '32.jpg'),
    (33, '33.jpg'),
    (34, '34.jpg'),
    (35, '35.jpg'),
    (36, '36.jpg'),
    (37, '37.jpg'),
    (38, '38.jpg'),
    (39, '39.jpg'),
    (40, '40.jpg'),
    (41, '41.jpg'),
    (42, '42.jpg'),
    (43, '43.jpg'),
    (44, '44.jpg'),
    (45, '45.jpg'),
    (46, '46.jpg'),
    (47, '47.jpg'),
    (48, '48.jpg'),
    (49, '49.jpg'),
    (50, '50.jpg'),
    (51, '51.jpg'),
    (52, '52.jpg'),
    (53, '53.jpg'),
    (54, '54.jpg'),
    (55, '55.jpg'),
    (56, '56.jpg'),
    (57, '57.jpg'),
    (58, '58.jpg'),
    (59, '59.jpg'),
    (60, '60.jpg'),
    (61, '61.jpg'),
    (62, '62.jpg'),
    (63, '63.jpg'),
    (64, '64.jpg'),
    (65, '65.jpg'),
    (66, '66.jpg'),
    (67, '67.jpg'),
    (68, '68.jpg'),
    (69, '69.jpg'),
    (70, '70.jpg'),
    (71, '71.jpg'),
    (72, '72.jpg'),
    (73, '73.jpg'),
    (74, '74.jpg'),
    (75, '75.jpg'),
    (76, '76.jpg'),
    (77, '77.jpg'),
    (78, '78.jpg'),
    (79, '79.jpg'),
    (80, '80.jpg'),
    (81, '81.jpg'),
    (82, '82.jpg'),
    (83, '83.jpg'),
    (84, '84.jpg'),
    (85, '85.jpg'),
    (86, '86.jpg'),
    (87, '87.jpg'),
    (88, '88.jpg'),
    (89, '89.jpg'),
    (90, '90.jpg'),
    (91, '91.jpg'),
    (92, '92.jpg'),
    (93, '93.jpg'),
    (94, '94.jpg'),
    (95, '95.jpg'),
    (96, '96.jpg'),
    (97, '97.jpg'),
    (98, '98.jpg'),
    (99, '99.jpg'),
    (100, '100.jpg'),
    (101, '101.jpg'),
    (102, '102.jpg'),
    (103, '103.jpg'),
    (104, '104.jpg'),
    (105, '105.jpg'),
    (106, '106.jpg'),
    (107, '107.jpg'),
    (108, '108.jpg'),
    (109, '109.jpg'),
    (110, '110.jpg'),
    (111, '111.jpg'),
    (112, '112.jpg'),
    (113, '113.jpg'),
    (114, '114.jpg'),
    (115, '115.jpg'),
    (116, '116.jpg'),
    (117, '117.jpg'),
    (118, '118.jpg'),
    (119, '119.jpg'),
    (120, '120.jpg'),
    (121, '121.jpg'),
    (122, '122.jpg'),
    (123, '123.jpg'),
    (124, '124.jpg'),
    (125, '125.jpg'),
    (126, '126.jpg'),
    (127, '127.jpg'),
    (128, '128.jpg'),
    (129, '129.jpg'),
    (130, '130.jpg'),
    (131, '131.jpg'),
    (132, '132.jpg'),
    (133, '133.jpg'),
    (134, '134.jpg'),
    (135, '135.jpg'),
    (136, '136.jpg'),
    (137, '137.jpg'),
    (138, '138.jpg'),
    (139, '139.jpg'),
    (140, '140.jpg'),
    (141, '141.jpg'),
    (142, '142.jpg'),
    (143, '143.jpg'),
    (144, '144.jpg'),
    (145, '145.jpg'),
    (146, '146.jpg'),
    (147, '147.jpg'),
    (148, '148.jpg'),
    (149, '149.jpg'),
    (150, '150.jpg'),
    (151, '151.jpg'),
    (152, '152.jpg'),
    (153, '153.jpg'),
    (154, '154.jpg'),
    (155, '155.jpg'),
    (156, '156.jpg'),
    (157, '157.jpg'),
    (158, '158.jpg'),
    (159, '159.jpg'),
    (160, '160.jpg'),
    (161, '161.jpg'),
    (162, '162.jpg'),
    (163, '163.jpg'),
    (164, '164.jpg'),
    (165, '165.jpg'),
    (166, '166.jpg'),
    (167, '167.jpg'),
    (168, '168.jpg'),
    (169, '169.jpg'),
    (170, '170.jpg'),
    (171, '171.jpg'),
    (172, '172.jpg'),
    (173, '173.jpg'),
    (174, '174.jpg'),
    (175, '175.jpg'),
    (176, '176.jpg'),
    (177, '177.jpg'),
    (178, '178.jpg'),
    (179, '179.jpg'),
    (180, '180.jpg'),
    (181, '181.jpg'),
    (182, '182.jpg'),
    (183, '183.jpg'),
    (184, '184.jpg'),
    (185, '185.jpg'),
    (186, '186.jpg'),
    (187, '187.jpg'),
    (188, '188.jpg'),
    (189, '189.jpg'),
    (190, '190.jpg'),
    (191, '191.jpg'),
    (192, '192.jpg'),
    (193, '193.jpg'),
    (194, '194.jpg'),
    (195, '195.jpg'),
    (196, '196.jpg'),
    (197, '197.jpg'),
    (198, '198.jpg'),
    (199, '199.jpg'),
    (200, '200.jpg'),
    (201, '201.jpg'),
    (202, '202.jpg'),
    (203, '203.jpg'),
    (204, '204.jpg'),
    (205, '205.jpg'),
    (206, '206.jpg'),
    (207, '207.jpg'),
    (208, '208.jpg'),
    (209, '209.jpg'),
    (210, '210.jpg'),
    (211, '211.jpg'),
    (212, '212.jpg'),
    (213, '213.jpg'),
    (214, '214.jpg'),
    (215, '215.jpg'),
    (216, '216.jpg'),
    (217, '217.jpg'),
    (218, '218.jpg'),
    (219, '219.jpg'),
    (220, '220.jpg'),
    (221, '221.jpg'),
    (222, '222.jpg'),
    (223, '223.jpg'),
    (224, '224.jpg'),
    (225, '225.jpg'),
    (226, '226.jpg'),
    (227, '227.jpg'),
    (228, '228.jpg'),
    (229, '229.jpg'),
    (230, '230.jpg'),
    (231, '231.jpg'),
    (232, '232.jpg'),
    (233, '233.jpg'),
    (234, '234.jpg'),
    (235, '235.jpg'),
    (236, '236.jpg'),
    (237, '237.jpg'),
    (238, '238.jpg'),
    (239, '239.jpg'),
    (240, '240.jpg');

INSERT INTO
    place_image (id, place_id, image_id)
VALUES
    (1, 1, 1),
    (2, 1, 2),
    (3, 1, 3),
    (4, 1, 4),
    (5, 1, 5),
    (6, 1, 6),
    (7, 1, 7),
    (8, 1, 8),
    (9, 1, 9),
    (10, 1, 10),
    (11, 1, 11),
    (12, 1, 12),
    (13, 2, 13),
    (14, 2, 14),
    (15, 2, 15),
    (16, 2, 16),
    (17, 2, 17),
    (18, 2, 18),
    (19, 2, 19),
    (20, 2, 20),
    (21, 2, 21),
    (22, 2, 22),
    (23, 2, 23),
    (24, 2, 24),
    (25, 3, 25),
    (26, 3, 26),
    (27, 3, 27),
    (28, 3, 28),
    (29, 3, 29),
    (30, 3, 30),
    (31, 3, 31),
    (32, 3, 32),
    (33, 3, 33),
    (34, 3, 34),
    (35, 3, 35),
    (36, 3, 36),
    (37, 4, 37),
    (38, 4, 38),
    (39, 4, 39),
    (40, 4, 40),
    (41, 4, 41),
    (42, 4, 42),
    (43, 4, 43),
    (44, 4, 44),
    (45, 4, 45),
    (46, 4, 46),
    (47, 4, 47),
    (48, 4, 48),
    (49, 5, 49),
    (50, 5, 50),
    (51, 5, 51),
    (52, 5, 52),
    (53, 5, 53),
    (54, 5, 54),
    (55, 5, 55),
    (56, 5, 56),
    (57, 5, 57),
    (58, 5, 58),
    (59, 5, 59),
    (60, 5, 60),
    (61, 6, 61),
    (62, 6, 62),
    (63, 6, 63),
    (64, 6, 64),
    (65, 6, 65),
    (66, 6, 66),
    (67, 6, 67),
    (68, 6, 68),
    (69, 6, 69),
    (70, 6, 70),
    (71, 6, 71),
    (72, 6, 72),
    (73, 7, 73),
    (74, 7, 74),
    (75, 7, 75),
    (76, 7, 76),
    (77, 7, 77),
    (78, 7, 78),
    (79, 7, 79),
    (80, 7, 80),
    (81, 7, 81),
    (82, 7, 82),
    (83, 7, 83),
    (84, 7, 84),
    (85, 8, 85),
    (86, 8, 86),
    (87, 8, 87),
    (88, 8, 88),
    (89, 8, 89),
    (90, 8, 90),
    (91, 8, 91),
    (92, 8, 92),
    (93, 8, 93),
    (94, 8, 94),
    (95, 8, 95),
    (96, 8, 96),
    (97, 9, 97),
    (98, 9, 98),
    (99, 9, 99),
    (100, 9, 100),
    (101, 9, 101),
    (102, 9, 102),
    (103, 9, 103),
    (104, 9, 104),
    (105, 9, 105),
    (106, 9, 106),
    (107, 9, 107),
    (108, 9, 108),
    (109, 10, 109),
    (110, 10, 110),
    (111, 10, 111),
    (112, 10, 112),
    (113, 10, 113),
    (114, 10, 114),
    (115, 10, 115),
    (116, 10, 116),
    (117, 10, 117),
    (118, 10, 118),
    (119, 10, 119),
    (120, 10, 120),
    (121, 11, 121),
    (122, 11, 122),
    (123, 11, 123),
    (124, 11, 124),
    (125, 11, 125),
    (126, 11, 126),
    (127, 11, 127),
    (128, 11, 128),
    (129, 11, 129),
    (130, 11, 130),
    (131, 11, 131),
    (132, 11, 132),
    (133, 12, 133),
    (134, 12, 134),
    (135, 12, 135),
    (136, 12, 136),
    (137, 12, 137),
    (138, 12, 138),
    (139, 12, 139),
    (140, 12, 140),
    (141, 12, 141),
    (142, 12, 142),
    (143, 12, 143),
    (144, 12, 144),
    (145, 13, 145),
    (146, 13, 146),
    (147, 13, 147),
    (148, 13, 148),
    (149, 13, 149),
    (150, 13, 150),
    (151, 13, 151),
    (152, 13, 152),
    (153, 13, 153),
    (154, 13, 154),
    (155, 13, 155),
    (156, 13, 156),
    (157, 14, 157),
    (158, 14, 158),
    (159, 14, 159),
    (160, 14, 160),
    (161, 14, 161),
    (162, 14, 162),
    (163, 14, 163),
    (164, 14, 164),
    (165, 14, 165),
    (166, 14, 166),
    (167, 14, 167),
    (168, 14, 168),
    (169, 15, 169),
    (170, 15, 170),
    (171, 15, 171),
    (172, 15, 172),
    (173, 15, 173),
    (174, 15, 174),
    (175, 15, 175),
    (176, 15, 176),
    (177, 15, 177),
    (178, 15, 178),
    (179, 15, 179),
    (180, 15, 180),
    (181, 16, 181),
    (182, 16, 182),
    (183, 16, 183),
    (184, 16, 184),
    (185, 16, 185),
    (186, 16, 186),
    (187, 16, 187),
    (188, 16, 188),
    (189, 16, 189),
    (190, 16, 190),
    (191, 16, 191),
    (192, 16, 192),
    (193, 17, 193),
    (194, 17, 194),
    (195, 17, 195),
    (196, 17, 196),
    (197, 17, 197),
    (198, 17, 198),
    (199, 17, 199),
    (200, 17, 200),
    (201, 17, 201),
    (202, 17, 202),
    (203, 17, 203),
    (204, 17, 204),
    (205, 18, 205),
    (206, 18, 206),
    (207, 18, 207),
    (208, 18, 208),
    (209, 18, 209),
    (210, 18, 210),
    (211, 18, 211),
    (212, 18, 212),
    (213, 18, 213),
    (214, 18, 214),
    (215, 18, 215),
    (216, 18, 216),
    (217, 19, 217),
    (218, 19, 218),
    (219, 19, 219),
    (220, 19, 220),
    (221, 19, 221),
    (222, 19, 222),
    (223, 19, 223),
    (224, 19, 224),
    (225, 19, 225),
    (226, 19, 226),
    (227, 19, 227),
    (228, 19, 228),
    (229, 20, 229),
    (230, 20, 230),
    (231, 20, 231),
    (232, 20, 232),
    (233, 20, 233),
    (234, 20, 234),
    (235, 20, 235),
    (236, 20, 236),
    (237, 20, 237),
    (238, 20, 238),
    (239, 20, 239),
    (240, 20, 240);