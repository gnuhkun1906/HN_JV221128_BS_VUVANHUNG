package ra.run;

import ra.bussinessImp.Book;

import java.util.*;

public class BookManagement {
    public static Scanner scanner = new Scanner(System.in);

    public static List<Book> listBooks = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            System.out.println("****************JAVA-HACKATHON-05-BASIC-MENU***************\n" +
                    "1. Nhập số sách và nhập thông tin sách \n" +
                    "2. Hiển thị thông tin các sách \n" +
                    "3. Sắp xếp sách theo lợi nhuận giảm dần \n" +
                    "4. Xóa sách theo mã sách \n" +
                    "5. Tìm kiếm sách theo tên sách \n" +
                    "6. Thay đổi trạng thái của sách theo mã sách \n" +
                    "7. Thoát ");
            System.out.println("Nhập vào lựa chọn của bạn ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    //Nhập thông tin sách
                    createBook();
                    break;
                case 2:
                    showListBooks();
                    break;
                case 3:
                    sortByInterest();
                    break;
                case 4:
                    deleteBook();
                    break;
                case 5:
                    searchByBookName();
                    break;
                case 6:
                    changeBookStatus();
                    break;
                case 7:
                    System.exit(0);
                    break;
                default:
                    System.out.println("lựa chọn của bạn không trùng khớp,vui lòng chọn lại");
                    choice = Integer.parseInt(scanner.nextLine());
            }
        }
    }

    public static void createBook() {

        System.out.println("Nhập vào số lượng sách mà bạn muốn thêm");
        int count = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < count; i++) {
            System.out.println("Nhập vào thông tin sách thứ " + (i + 1));
            Book newBook = new Book();
            newBook.inputData();
            if (listBooks.size() == 0) {
                newBook.setBookId(1);
            } else {
                int newBookId = listBooks.get(listBooks.size() - 1).getBookId() + 1;
                newBook.setBookId(newBookId);
            }
            listBooks.add(newBook);
        }


    }

    public static void showListBooks() {
        for (Book book : listBooks) {
            book.displayData();
        }
    }

    public static void sortByInterest() {
        Collections.sort(listBooks);

    }

    public static void deleteBook() {


        System.out.println("Nhập vào mã sách mà banh muốn xóa");
        int inputBookId = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < listBooks.size(); i++) {
            if (listBooks.get(i).getBookId() == inputBookId) {
                listBooks.remove(listBooks.get(i));
                System.out.println("Xóa thành công");
                break;
            }
        }
        System.out.println("Không có sách");

    }

    public static void searchByBookName() {

        System.out.println("Nhập teen sách mà bận cần tìm kiếm ");
        String inputBookName = scanner.nextLine();
        List<Book> searchBookList = new ArrayList<Book>();
        for (Book bookSearch : listBooks
        ) {
        if (bookSearch.getBookName().contains(inputBookName)){
            searchBookList.add(bookSearch);
        }
        }
        System.out.println("danh sách tìm kiếm :");
        for (Book list:searchBookList
             ) {
            list.displayData();
        }
    }
    public static void changeBookStatus() {


        System.out.println("Nhập vào mã sách mà bạn muốn thay đổi trạng thái");
        int inputBookStatus=Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < listBooks.size(); i++) {
            if (listBooks.get(i).getBookId() == inputBookStatus) {
                listBooks.get(i).setBookStatus(!listBooks.get(i).getBookStatus());
                return;
            }
        }
        System.out.println("ID không tồn tại");
    }
}
