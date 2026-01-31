import java.awt.*;
import java.util.Scanner;
import java.util.regex.Pattern;

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
                    updateStudent(listStudent,numberStudent);
                    break;
                case 4:
                    numberStudent= deleteStudent(listStudent,numberStudent);
                    break;
                case 5:
                    searchValue(listStudent,numberStudent);
                    break;
                case 6:
                    System.out.println("bạn chọn thoát chương trình thành công!!!");
                    break;
                default:
                    System.err.println(" lựa chọn ko hợp lệ");
            }

        }while(choice !=6);
    }

    public static void printListStudent(String[] listStudent,int numberStudent) {
         System.out.print("======danh sách sinh vien=====\n");
         System.out.print("STT | Tên Sinh viên\n");
        if (numberStudent != 0){
            for (int i=0;i<numberStudent;i++){
                System.out.printf(" %d  | %s \n",i,listStudent[i]);
            }
        }else{
            System.out.println("Hiện tại không có sinh viên nào!!!");
        }
    }

    public static int addStudent(String[] listStudent,int numberStudent){
        String NameStudent;
        boolean result;
        Scanner sc= new Scanner(System.in);

        System.out.print("mời bạn nhập số lượng học sinh cần mã sinh viên: ");
        int numberAdd= Integer.parseInt(sc.nextLine());

        if (numberStudent == 100){
            System.out.println("danh sách đã đầy!!");
            return numberStudent;
        }

        if (listStudent.length -numberStudent <numberAdd ){
            System.out.printf("danh sách chỉ còn %d vị trí, không đủ để thêm %d sinh viên vào", listStudent.length -numberStudent,numberAdd);
            return numberStudent;
        }
        for (int i=0;i<numberAdd;i++) {
            do {
                System.out.printf("moi ban nhập tên sinh vien %d (bắt đầu bằng B + 7 số bất kì): ",i);
                 NameStudent = sc.nextLine();
                 result = Pattern.compile("^B[0-9]{7}$").matcher(NameStudent).matches();
                 if (!result){
                     System.out.println("bạn nhập ko đúng định dạng!!! vui lòng nhập lại");
                 }
            }while (!result);
            /*dung listStudent[numberStudent] thay cho listStudent[i] vì nếu mà thêm tiêếp thì nó sẽ chèn*/
            listStudent[numberStudent]=NameStudent;
            numberStudent+=1;
        }
        System.out.printf("bạn đã nhập thành công %d sinh viên\n", numberAdd);
        return numberStudent;
    }

    public static int deleteStudent( String[] listStudent, int numberStudent ) {
        Scanner sc= new Scanner(System.in);
        int indexDelete=-1; ;

        System.out.print("mời bạn nhập mã sinh viên cần xóa: ");
        String studentDelete = sc.nextLine();
        for (int i =0 ;i<numberStudent;i++){
            if (listStudent[i].equals(studentDelete) ){
                indexDelete = i ;
                break;
            }
        }

        if ( indexDelete !=-1){
            for (int i =indexDelete ;i<numberStudent-1;i++){
                listStudent[i] =listStudent[i+1];
            }
            return numberStudent-1;
        }else {
            System.out.println("khoont tìm thấy tên cần xóa");
            return numberStudent;
        }

    }

    public  static  void updateStudent(String[] listStudent,int numberStudent){
        Scanner sc = new Scanner(System.in);
        String NameStudent;
        boolean result;

        System.out.println("mời bạn nhập stt mà sinh vien muốn cập nhật: ");
        int indexUpdate =Integer.parseInt(sc.nextLine());
        if (indexUpdate < numberStudent && indexUpdate >=0 ){
            System.out.printf("dữ liệu cũ: %d | %s \n",indexUpdate,listStudent[indexUpdate]);

                do {
                    System.out.printf("moi ban nhập tên mới của sinh vien %s (bắt đầu bằng B + 7 số bất kì): ",listStudent[indexUpdate]);
                    NameStudent = sc.nextLine();
                    result = Pattern.compile("^B[0-9]{7}$").matcher(NameStudent).matches();
                    if (!result){
                        System.out.println("bạn nhập ko đúng định dạng!!! vui lòng nhập lại");
                    }
                }while (!result);
            listStudent[indexUpdate]=NameStudent;
            System.out.print("cập nhật thông tin thành công\n");
        }else {
            System.out.print("không thấy học sinh này\n");
        }
    }

    public  static  void searchValue(String[] listStudent,int numberStudent){
        boolean find =false;
        Scanner sc = new Scanner(System.in);
        System.out.print("Mời bạn nhập bên mã sinh viên cần tìm: ");
        String value =sc.nextLine().toLowerCase();
        System.out.println("dữ liệu cần tìm:");
        for (int i=0 ;i<numberStudent;i++){

            if (listStudent[i].toLowerCase().contains(value)){
                System.out.printf("- %s \n",listStudent[i]);
                find= true;
            }
        }
        if (!find)
        {
            System.out.println("dữ liệu truyền vào ko thấy");
        }
    }
}