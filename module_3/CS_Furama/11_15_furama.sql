USE furama;

SELECT distinct
dvdk.ma_dich_vu_di_kem, dvdk.ten_dich_vu_di_kem
FROM khach_hang kh
JOIN loai_khach lk ON kh.ma_loai_khach = lk.ma_loai_khach
JOIN hop_dong hd ON kh.ma_khach_hang = hd.ma_khach_hang
JOIN hop_dong_chi_tiet hdct ON hd.ma_hop_dong = hdct.ma_hop_dong
JOIN dich_vu_di_kem dvdk ON hdct.ma_dich_vu_di_kem = dvdk.ma_dich_vu_di_kem
WHERE 
lk.ten_loai_khach = 'Diamond'
AND
(kh.dia_chi LIKE '%Vinh%' OR kh.dia_chi LIKE '%Quảng Ngãi%');




SELECT hd.ma_hop_dong, nv.ho_ten AS ten_nhan_vien, kh.ho_ten AS ten_khach_hang, kh.so_dien_thoai, dv.ten_dich_vu, hd.tien_dat_coc,
COALESCE(SUM(hdct.so_luong), 0) AS so_luong_dich_vu_di_kem
FROM hop_dong hd
JOIN nhan_vien nv ON hd.ma_nhan_vien = nv.ma_nhan_vien
JOIN khach_hang kh ON hd.ma_khach_hang = kh.ma_khach_hang
JOIN dich_vu dv ON hd.ma_dich_vu = dv.ma_dich_vu
LEFT JOIN hop_dong_chi_tiet hdct ON hd.ma_hop_dong = hdct.ma_hop_dong
LEFT JOIN dich_vu_di_kem dvdk ON hdct.ma_dich_vu_di_kem = dvdk.ma_dich_vu_di_kem
WHERE
EXISTS (
SELECT 1
FROM hop_dong hd2
WHERE hd2.ma_dich_vu = hd.ma_dich_vu
AND hd2.ngay_lam_hop_dong BETWEEN '2020-10-01' AND '2020-12-31'
) 
AND
NOT EXISTS (
SELECT 1
FROM hop_dong hd3
WHERE hd3.ma_dich_vu = hd.ma_dich_vu
AND hd3.ngay_lam_hop_dong BETWEEN '2021-01-01' AND '2021-06-30'
)
GROUP BY hd.ma_hop_dong, nv.ho_ten, kh.ho_ten, kh.so_dien_thoai, dv.ten_dich_vu, hd.tien_dat_coc;




SELECT dvdk.ma_dich_vu_di_kem, dvdk.ten_dich_vu_di_kem,
SUM(hdct.so_luong) AS tong_su_dung
FROM dich_vu_di_kem dvdk
JOIN hop_dong_chi_tiet hdct ON dvdk.ma_dich_vu_di_kem = hdct.ma_dich_vu_di_kem
JOIN hop_dong hd ON hdct.ma_hop_dong = hd.ma_hop_dong
GROUP BY dvdk.ma_dich_vu_di_kem
HAVING tong_su_dung = 
(
SELECT MAX(tong)
FROM  (
SELECT SUM(hdct.so_luong) AS tong
FROM hop_dong_chi_tiet hdct
GROUP BY hdct.ma_dich_vu_di_kem
) AS temp
);



SELECT hd.ma_hop_dong, ldv.ten_loai_dich_vu, dvdk.ten_dich_vu_di_kem, 
COUNT(hdct.ma_dich_vu_di_kem) AS so_lan_su_dung
FROM hop_dong hd
JOIN hop_dong_chi_tiet hdct ON hd.ma_hop_dong = hdct.ma_hop_dong
JOIN dich_vu_di_kem dvdk ON hdct.ma_dich_vu_di_kem = dvdk.ma_dich_vu_di_kem
JOIN dich_vu dv ON hd.ma_dich_vu = dv.ma_dich_vu
JOIN loai_dich_vu ldv ON dv.ma_loai_dich_vu = ldv.ma_loai_dich_vu
GROUP BY hd.ma_hop_dong, ldv.ten_loai_dich_vu, dvdk.ten_dich_vu_di_kem
HAVING COUNT(hdct.ma_dich_vu_di_kem) = 1;




SELECT nv.ma_nhan_vien, nv.ho_ten, td.ten_trinh_do, bp.ten_bo_phan, nv.so_dien_thoai, nv.dia_chi
FROM nhan_vien nv
JOIN trinh_do td ON nv.ma_trinh_do = td.ma_trinh_do
JOIN bo_phan bp ON nv.ma_bo_phan = bp.ma_bo_phan
LEFT JOIN hop_dong hd ON nv.ma_nhan_vien = hd.ma_nhan_vien
AND hd.ngay_lam_hop_dong BETWEEN '2021-01-01' AND '2021-12-31'
GROUP BY nv.ma_nhan_vien, nv.ho_ten, td.ten_trinh_do, bp.ten_bo_phan, nv.so_dien_thoai, nv.dia_chi
HAVING COUNT(hd.ma_hop_dong) <= 3;


