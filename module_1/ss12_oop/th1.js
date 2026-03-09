// Khai báo lớp MyDate
class MyDate{
    // Hàm khởi tạo (constructor) nhận 3 tham số: day, month, year
    constructor(day, month, year) {
        // Lưu giá trị ngày vào thuộc tính instance
        this.day = day;

        // Lưu giá trị tháng vào thuộc tính instance
        this.month = month;

        // Lưu giá trị năm vào thuộc tính instance
        this.year = year;
    }

    // Trả về thuộc tính day hiện tại
    getDay() {
        return this.day;
    }

    // Trả về thuộc tính month hiện tại
    getMonth() {
        return this.month;
    }

    // Trả về thuộc tính year hiện tại
    getYear() {
        return this.year;
    }

    // Thiết đặt (gán) giá trị day
    setDay() {
        this.day = day;
    }

    // Thiết đặt (gán) giá trị month
    setMonth() {
        this.month = month;
    }

    // Thiết đặt (gán) giá trị year
    setYear() {
        this.year = year;
    }

    // Thiết đặt cùng lúc day, month, year
    setDate(day, month, year) {
        this.day = day;
        this.momth = month;
        this.year = year;
    }

    //Trả về chuỗi định dạng "dd/mm/yyyy" với leading zero
    toString() {
        // Chuyển số ngày thành chuỗi và nếu chỉ 1 chữ số thì thêm '0' ở trước
        // padStart(2,'0') đảm bảo chuỗi có độ dài tối thiểu 2 ký tự

        const dd = this.day.toString().padStart(2, '0');

        const mm = this.month.toString().padStart(2, '0');

        // Năm thường có 4 chữ số, conver
    }
}