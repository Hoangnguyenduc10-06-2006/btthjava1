import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {
        String[] listStudent = new String[100];
        int numberStudent = 0;
        int choice ;
        do{

            Scanner sc = new Scanner(System.in);
            System.out.print("---------menu------------\n");
            System.out.print("1.hiển thị\n");
            System.out.print("2.thêm mới\n");
            System.out.print("3 cập nhật\n");
            System.out.print("4.xóa\n");
            System.out.print("5 tìm kiếm\n");
            System.out.print("6 thoát\n");
            System.out.print("mời bạn nhận lựa chọn cửa bạn: ");
            choice= Integer.parseInt(sc.nextLine());
            switch (choice){
                case 1:
                    printListStudent(listStudent,numberStudent);
                    break;
                case 2:
                    numberStudent= addStudent(listStudent,numberStudent);
                    break;
                case 3:
                    break;
                case 4:
                    System.out.print("moiwf bạn nhap id tên sinh vien cần xóa: ");
                    String indexDelete= sc.nextLine();
                    deleteStudent(listStudent,indexDelete,numberStudent);
                    break;
                case 5:
                    break;
                case 6:
                    System.out.println("bạn chọn thoát chương trình thành công!!!");
                    break;
                default:
                    System.err.println(" lựa chọn ko hợp lệ");
            }

        }while(choice !=6);
    }

    public static void printListStudent(String[] listStudent,int numberStudent){
        System.out.print("---danh sách sinh vien----\n");
        for (int i=0;i<numberStudent;i++){
            System.out.printf("%s \n",listStudent[i]);
        }
    }
    public static int addStudent(String[] listStudent,int numberStudent){

        System.out.print("mời bạn nhập số lượng học sinh cần mã sinh viên: ");
        Scanner sc= new Scanner(System.in);
        int numberAdd= Integer.parseInt(sc.nextLine());
        for (int i=0;i<numberAdd;i++) {
            System.out.print("moi ban nhập tên sinh vien: ");
            String NameStudent = sc.nextLine();
            listStudent[i]=NameStudent;
            numberStudent+=1;
        }
        return numberStudent;
    }

    public static void deleteStudent(String[] listStudent,String indexDelete,int numberStudent){

    }
}