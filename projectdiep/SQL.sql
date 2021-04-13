use Project2

 insert into Admin(id,password,fullname,birthday,gender,phone,role)
 values ('NV001','123456','Tran Thien Hieu','1999-12-12',1,'0905975216','Quan Tri'),
		('NV002','123456','Le Van Linh','1999-05-02',1,'0905642866','NV Sale'),
		('NV003','123456','Le Van Thuan','1999-07-21',1,'0345678654','NV Ky Thuat'),
		('NV004','123456','Doan Ngoc Diep','2000-08-11',0,'0399876785','NVQL Hop Dong'),
		('NV005','123456','Nguyen Thi Phuong','2000-04-16',0,'0885598888','NVQL Bai Viet');

insert into BDS(id,name,address,district,city,price,s,people,time,phone,note,type,image)
values ('B0001','CHINH CHU BAN NHA 2 TANG K145 HOANG VAN THAI.NHA DEP,THIET KE HIEN DAI,TRE TRUNG,DAY DU CONG NANG.','K145 Hoang Van Thai,Phuong Hoa Hiep Nam','Lien Chieu', 'Da Nang',2 0000000,120,'Nguyen Anh Tai','2020-11-15','0997876543',
		'Chinh chu ban nha 2 tang K145 Hoang Van Thai.nha dep,thiet ke hien dai,tre trung,day du cong nang.3pn,2wc,p tho,p bep.san de xe.san phoi.HUONG tay nam.duong 3m thong thoang.DT dat 60,4m2.
		+ DT su dung 120m2. so hong chinh chu. Gia ban 2ty1 nha dung hinh.co ho tro vay ngan hang','Nha Rieng','B01.jpg'),
		('B0002','BAN NHA MAT PHO TAI DUONG BUI TRANG CHUOC KHU DAN CU HOA XUAN- QUAN CAM LE - DA NANG - DIEN TICH: 100M² DIEN TICH SU DUNG: 318.5M2','Duong Bui Trang Chuoc, Phuong Hoa Xuan','Cam Le', 'Da Nang',25000000,205,'Nguyen Thanh Dat','2020-11-15','0987547573',
		'Ban nha mat pho tai Duong Bui Trang Chuoc Khu Dan Cu Hoa Xuan- Quan Cam Le - Da Nang
		- Dien tich: 100m² Dien tich su dung: 318.5m2
		- Nha 4 tang duong Bui Trang Chuoc_ Duong 10,5m, via he 5m, (noi lien 2 nhanh song )
		- Huong: Tay Nam
		- Thiet ke theo phong cach hien dai thoang mat
		- Noi that day du don vao o lien,con moi 100%.
		Gom 4 tang:
		+ Tang 1: Trong, 1 WC (Kinh doanh, mo Van phong cty, hoac de xe oto)
		+ Tang 2: 1 phong khach; 1 Bep; 1 WC; 1 phong ngu co 1 WC ben trong
		+ Tang 3: 2 Phong ngu + 2 WC
		+ Tang 4: 1 phong tho + san truoc, 1 phong giat + san sau.
		Vi tri nam giao thong thuan loi qua thanh pho 7 phut , di bai tam (Tan Tra) 10 phut , khu vuc khi hau mat me, an ninh, tien ich day du, kinh doanh tot.','Nha Rieng','B05.jpg'),
		('B0003','CHINH CHU CAN BAN GAP NHA CAP 4 DO ME, NHA DEP THICH HOP DE O TAI QUAN LIEN CHIEU, TP. DA NANG','Kiet 207 Nguyen Van Cu, Phuong Hoa Hiep Bac','Lien Chieu', 'Da Nang',25000000,120,'Pham Minh Vien','2020-11-15','0333979479',
		'Gia re bat ngo cho khach thien chi muon mua nha (mtg).Cong nang nha day du, mat tien co the kinh doanh hoac cho thue.Nha moi 3 tang, nha xay kien co thiet ke dep 
		hien dai.Gan cong vien Thanh Nien, ho Khue Trung, gan song, Gan truong truong cap 1,2,3, gan cho...Gia thuong luong chinh chu.','Mat Bang','B09.jpg'),
		('B0004','CHINH CHU CAN BAN BIET THU GOC DUONG TO HUU','Duong To Huu','Hai Chau','Da Nang',70000000,200,'Lam Van Vuong','2020-11-15','0905218378','Khu nha co vi tri thuan loi, 
		2 mat tien, nam trong khu dan cu sam uat van minh. Gan cong vien, benh vien, truong hoc.','Nha Rieng','B13.jpg'),
		('B0005','BAN NHA MAT PHO TRUNG TAM QUAN HAI CHAU','Duong Chi Lang',' Hai Chau', 'Da Nang',1200000,250,'Nguyen Trung Vinh','2020-11-15','0898349327','Ban nha chinh chu,
		 mat tien duong Chi Lang, Quan Hai Chau, TP Da Nang. Ngoi nha nam o vi tri dac dia, thuoc khu vuc cac duong pho trung tam buon ban, thuong mai: Duong Le Duan, duong Hung Vuong,
		  duong Chi Lang..., noi day la khu vuc sam uat bac nhat cua thanh pho Da Nang.','Nha Rieng','B17.jpg');

 insert into BDS(id,name,address,district,city,price,s,people,time,phone,note,type,image)
values ('T0001','Nha Cap 4 Cho Thue','82 Ho Quy Ly','Thanh Khe', 'Da Nang',300000,100,'Nguyen Anh Tai','2020-11-15','0997876543','Dien tich 100m2 gom 2 
phong ngu, phong khach, bep, ve sinh, san phoi do rong, cho de xe rong. Co cho dau o to.Nha full noi that gom bep tu cao cap, tivi, tu 
lanh, dieu hoa, ban an, giuong nem, nong lanh, quat... Chi don vao o.Dong tien 3 thang 1 lan, coc 1 thang. Uu tien thue lau dai.','Nha Rieng','T01.jpg'),
		('T0002','CHO THUE NHA MAT TIEN DUONG ME LINH','45 Duong Me Linh','Lien Chieu', 'Da Nang',500000,100,'Nguyen Thanh Dat','2020-11-15','0987547573','Cho thue nha mat tien duong 
 Me Linh, Lien Chieu, Da Nang, noi that tuong doi hoan thien, Thich hop van phong cong ty, Giao thong thuan tien.','Nha Rieng','T05.jpg'),
		('T0003','CHO THUE MAT BANG LAM VAN PHONG','565 Duong Nguyen Tat Thanh, Phuong Xuan Ha','Thanh Khe', 'Da Nang',250000,100,'Pham Minh Vien','2020-11-15','0333979479','CHO THUE MAT 
 BANG 563-567 NGUYEN TAT THANH, DA NANG. THUAN TIEN CHO VIEC MO VAN PHONG-TRUNG TAM, SHOWROOM TRIEN LAM, QUAN AN, NHA HANG, SIEU THI...','Mat Bang','T09.jpg'),
		('T0004','CHO THUE NHA MAT TIEN NGUYEN HUU THO','122 NGUYEN HUU THO','Hai Chau', 'Da Nang',100000,375,'Lam Van Vuong','2020-11-15','0905218378','Vi tri 
 Nguyen Huu Tho, gan duong Xo Viet Nghe Tinh, Dien tich: 15 x 25 m2, nha thong suot - nhu hinh, Phu hop lam Showroom noi that, gara, vat lieu xay dung, thiet bi 
 trung bay cac mat hang gia dung..., Gia cuc ki tot hien tai.','Nha Rieng','T13.jpg'),
		('T0005','Cho thue nha nguyen can 2 mat tien','399 Kinh Duong Vuong','Lien Chieu', 'Da Nang',120000,210,'Nguyen Trung Vinh','2020-11-15','0898349327','Cho thue nha nguyen 
 can 2 mat tien duong lon khu KD nhieu nghanh nghe, so nha 399 kinh Duong vuong, Q lien chieu, tp Da Nang. DT 10m*21m nha mo cua 2 mat duong, long nha de thong 
 rong 200m2 khong ngan vach, phan sau la ve sinh. Nha rong rai rat thuan tien KD buon ban.','Nha Rieng','T17.jpg');
insert into BDSImage(id,image,bds_id)
values (1,'T01.jpg','T0001'),
		(2,'T02.jpg','T0001'),
		(3,'T03.jpg','T0001'),
		(4,'T04.jpg','T0001'),
		(5,'T05.jpg','T0002'),
		(6,'T06.jpg','T0002'),
		(7,'T07.jpg','T0002'),
		(8,'T08.jpg','T0002'),
		(9,'T09.jpg','T0003'),
		(10,'T10.jpg','T0003'),
		(11,'T11.jpg','T0003'),
		(12,'T12.jpg','T0003'),
		(13,'T13.jpg','T0004'),
		(14,'T14.jpg','T0004'),
		(15,'T15.jpg','T0004'),
		(16,'T16.jpg','T0004'),
		(17,'T17.jpg','T0005'),
		(18,'T18.jpg','T0005'),
		(19,'T19.jpg','T0005'),
		(20,'T20.jpg','T0005');

insert into BDSImage(id,image,bds_id)
values (21,'B01.jpg','B0001'),
		(22,'B02.jpg','B0001'),
		(23,'B03.jpg','B0001'),
		(24,'B04.jpg','B0001'),
		(25,'B05.jpg','B0002'),
		(26,'B06.jpg','B0002'),
		(27,'B07.jpg','B0002'),
		(28,'B08.jpg','B0002'),
		(29,'B09.jpg','B0003'),
		(30,'B10.jpg','B0003'),
		(31,'B11.jpg','B0003'),
		(32,'B12.jpg','B0003'),
		(33,'B13.jpg','B0003'),
		(34,'B14.jpg','B0004'),
		(35,'B15.jpg','B0004'),
		(36,'B16.jpg','B0004'),
		(37,'B17.jpg','B0005'),
		(38,'B18.jpg','B0005'),
		(39,'B19.jpg','B0005'),
		(40,'B20.jpg','B0005');
INSERT INTO Users(email,password, fullname,birthday,gender,phone)
VALUES ('lelinh99th@gmail.com',' 123456', 'le Van Linh','2000-12-10',1,0846244632),
		('hoa99th@gmail.com',' 234567', 'Nguyen Thi Hoa','1999-10-07',1,0847384592),
		('binlh02@gmail.com',' 345678', 'Le Hoang Bin','2000-12-07',0,08462958999),
		('My333@gmail.com',' 456789', 'Nguyen Thi My','1999-10-02',0,0846244223),
		('Cuc809@gmail.com',' 567890', 'Vo Thi Cuc','2000-12-10',1,0846244888),
		('thuanHV@gmail.com',' 678901', 'Hoang Van Thuan','1999-04-03',0,0846333444),
		('hien000@gmail.com',' 789012', 'Le Trung Hieu','2000-12-30',0,08462000332),
		('Ngoc009@gmail.com',' 890123', 'Le Hoang Ngoc','1999-10-02',0,0846244232),
		('Nam99@gmail.com',' 901234', 'Le Van Nam','2000-7-10',0,0886244632),
		('hoang749@gmail.com',' 012345', 'Nguyen Thanh Hoang','1999-10-03',1,0846333632),
		('quan123123@gmail.com',' 123456', 'Tran huy Quan','2000-12-30',0,0846295833),
		('tientien@gmail.com',' 234567', 'Le Thi Tien','1999-10-02',0,0846243322),
		('TAlinh67th@gmail.com',' 345678', 'tran Anh Linh','2000-12-10',1,0843334632),
		('thuan123@gmail.com',' 456789', 'Le Van Thuan','1999-10-03',1,0846337732),
		('hieu123@gmail.com',' 567890', 'Nguyen Dien Hieu','2000-12-30',0,0846295833),
		('diep123@gmail.com',' 678901', 'Le Thi Diep','1999-10-02',0,0846240122),
		('phuong123@gmail.com',' 789012', 'Le Thi Phuong','2000-02-02',1,0846240899);
INSERT INTO QLHop_Dong(id,time,files,type,email_user)
VALUES ('HD001','2020-01-12','binlh.pdf',1,'binlh02@gmail.com'),
		('HD002','2020-03-23','cucvt.pdf',1,'Cuc809@gmail.com'),
		('HD003','2020-05-05','mynt.pdf',0,'My333@gmail.com'),
		('HD004','2020-01-05','hoant.pdf',0,'hoang749@gmail.com'),
		('HD005','2020-01-01','linhvl.pdf',0,'lelinh99th@gmail.com');