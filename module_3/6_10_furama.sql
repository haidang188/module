USE furama;

SELECT dv.ma_dich_vu, dv.ten_dich_vu, dv.dien_tich, dv.chi_phi_thue, ldv.ten_loai_dich_vu
FROM dich_vu dv
LEFT JOIN loai_dich_vu ldv ON dv.ma_loai_dich_vu = ldv.ma_loai_dich_vu
LEFT JOIN hop_dong hd ON hd.ma_dich_vu = dv.ma_dich_vu 
AND hd.ngay_lam_hop_dong BETWEEN '2021-01-01' AND '2021-03-31'
WHERE hd.ma_hop_dong IS NULL;

SELECT dv.ma_dich_vu, dv.ten_dich_vu, dv.dien_tich, dv.so_nguoi_toi_da, dv.chi_phi_thue, ldv.ten_loai_dich_vu
FROM dich_vu dv
LEFT JOIN loai_dich_vu ldv ON dv.ma_loai_dich_vu = ldv.ma_loai_dich_vu
WHERE 
EXISTS (
SELECT 1
FROM hop_dong hd
WHERE hd.ma_dich_vu = dv.ma_dich_vu
AND hd.ngay_lam_hop_dong BETWEEN '2020-01-01' AND '2020-12-31'
) 
AND
NOT EXISTS (
SELECT 1
FROM hop_dong hd
WHERE hd.ma_dich_vu = dv.ma_dich_vu
AND hd.ngay_lam_hop_dong BETWEEN '2021-01-01' AND '2021-12-31'
);

SELECT distinct ho_ten
FROM khach_hang;

SELECT ho_ten
FROM khach_hang
GROUP BY ho_ten;


SELECT k1.ho_ten
FROM khach_hang k1
WHERE NOT EXISTS (
SELECT 1
FROM khach_hang k2
WHERE k1.ho_ten = k2.ho_ten
AND k1.ma_khach_hang > k2.ma_khach_hang
);

SELECT 
MONTH(ngay_lam_hop_dong) AS thang,
COUNT(DISTINCT ma_khach_hang) AS so_khach
FROM hop_dong hd
WHERE ngay_lam_hop_dong BETWEEN '2021-01-01' AND '2021-12-31'
GROUP BY MONTH(ngay_lam_hop_dong)
ORDER BY thang;

SELECT hd.ma_hop_dong, hd.ngay_lam_hop_dong, hd.ngay_ket_thuc, hd.tien_dat_coc,
COALESCE (SUM(hdct.so_luong), 0) AS so_luong_dich_vu_di_kem
FROM hop_dong hd
LEFT JOIN hop_dong_chi_tiet hdct ON hd.ma_hop_dong = hdct.ma_hop_dong
GROUP BY hd.ma_hop_dong, hd.ngay_lam_hop_dong, hd.ngay_ket_thuc, hd.tien_dat_coc;


