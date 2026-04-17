USE furama;

DELETE nv
FROM nhan_vien nv
LEFT JOIN hop_dong hd
ON nv.ma_nhan_vien = hd.ma_nhan_vien
AND hd.ngay_lam_hop_dong BETWEEN '2019-01-01' AND '2021-12-31'
WHERE hd.ma_hop_dong IS NULL;

SET SQL_SAFE_UPDATES = 0;


UPDATE khach_hang 
SET ma_loai_khach = (
SELECT ma_loai_khach
FROM loai_khach
WHERE ten_loai_khach = 'Diamond'
)
WHERE ma_khach_hang IN (
SELECT * FROM (
SELECT kh.ma_khach_hang
FROM khach_hang kh
JOIN loai_khach lk ON kh.ma_loai_khach = lk.ma_loai_khach
JOIN hop_dong hd ON kh.ma_khach_hang = hd.ma_khach_hang
JOIN dich_vu dv ON hd.ma_dich_vu = dv.ma_dich_vu
LEFT JOIN hop_dong_chi_tiet hdct ON hd.ma_hop_dong = hdct.ma_hop_dong
LEFT JOIN dich_vu_di_kem dvdk ON hdct.ma_dich_vu_di_kem = dvdk.ma_dich_vu_di_kem
WHERE lk.ten_loai_khach = 'Platinum'
AND hd.ngay_lam_hop_dong BETWEEN '2021-01-01' AND '2021-12-31'
GROUP BY kh.ma_khach_hang
HAVING SUM(dv.chi_phi_thue + COALESCE(hdct.so_luong * dvdk.gia, 0)) > 10000000
) AS temp
);



DELETE FROM hop_dong_chi_tiet
WHERE ma_hop_dong IN (
SELECT ma_hop_dong FROM (
SELECT hd.ma_hop_dong
FROM hop_dong hd
WHERE hd.ngay_lam_hop_dong < '2021-01-01'
)AS temp
);

DELETE FROM hop_dong
WHERE ngay_lam_hop_dong < '2021-01-01';

DELETE FROM khach_hang
WHERE ma_khach_hang IN (
SELECT * FROM (
SELECT hd.ma_khach_hang
FROM hop_dong hd
WHERE hd.ngay_lam_hop_dong < '2021-01-01'
) AS temp
);




UPDATE dich_vu_di_kem
SET gia = gia * 2
WHERE ma_dich_vu_di_kem IN (
SELECT * FROM (
SELECT dvdk.ma_dich_vu_di_kem
FROM dich_vu_di_kem dvdk
JOIN hop_dong_chi_tiet hdct ON dvdk.ma_dich_vu_di_kem = hdct.ma_dich_vu_di_kem
JOIN hop_dong hd ON hdct.ma_hop_dong = hd.ma_hop_dong
WHERE ngay_lam_hop_dong BETWEEN '2021-01-01' AND '2021-12-31'
GROUP BY dvdk.ma_dich_vu_di_kem
HAVING SUM(hdct.so_luong) > 10
) AS temp

);



SELECT 
nv.ma_nhan_vien AS id,
nv.ho_ten,
nv.email,
nv.so_dien_thoai,
nv.ngay_sinh,
nv.dia_chi
FROM nhan_vien nv

UNION

SELECT 
kh.ma_khach_hang AS id,
kh.ho_ten,
kh.email,
kh.so_dien_thoai,
kh.ngay_sinh,
kh.dia_chi
FROM khach_hang kh;
 

