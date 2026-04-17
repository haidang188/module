USE furama;

SELECT *
FROM nhan_vien
WHERE (
ho_ten LIKE 'H%' OR
ho_ten LIKE 'T%'OR
ho_ten LIKE 'K%'
)
AND CHAR_LENGTH(ho_ten) <= 15;

SELECT *,
TIMESTAMPDIFF(YEAR, ngay_sinh, CURDATE()) AS tuoi
FROM khach_hang
WHERE (dia_chi LIKE '%Đà Nẵng%' OR dia_chi LIKE '%Quảng Trị%')
AND 
(TIMESTAMPDIFF(YEAR, ngay_sinh, CURDATE()) BETWEEN 18 AND 50);

SELECT kh.ho_ten, 
COUNT(hd.ma_hop_dong) AS so_lan_dat
FROM khach_hang kh
JOIN hop_dong hd ON kh.ma_khach_hang = hd.ma_khach_hang
JOIN loai_khach lk ON kh.ma_loai_khach = lk.ma_loai_khach
WHERE lk.ten_loai_khach = 'Diamond'
GROUP BY kh.ma_khach_hang, kh.ho_ten
ORDER BY so_lan_dat ASC;

SELECT kh.ma_khach_hang, kh.ho_ten, lk.ten_loai_khach, hd.ma_hop_dong, hd.ngay_lam_hop_dong, hd.ngay_ket_thuc, dv.ten_dich_vu,
dv.chi_phi_thue + COALESCE(SUM(hdct.so_luong * dvdk.gia), 0) AS tong_tien
FROM khach_hang kh 
JOIN loai_khach lk ON kh.ma_loai_khach = lk.ma_loai_khach
LEFT JOIN hop_dong hd ON kh.ma_khach_hang = hd.ma_khach_hang
LEFT JOIN dich_vu dv ON dv.ma_dich_vu = hd.ma_dich_vu
LEFT JOIN hop_dong_chi_tiet hdct ON hdct.ma_hop_dong = hd.ma_hop_dong
LEFT JOIN dich_vu_di_kem dvdk ON dvdk.ma_dich_vu_di_kem = hdct.ma_dich_vu_di_kem
GROUP BY kh.ma_khach_hang, kh.ho_ten, lk.ten_loai_khach, hd.ma_hop_dong, hd.ngay_lam_hop_dong, hd.ngay_ket_thuc, dv.ten_dich_vu,
dv.chi_phi_thue;
