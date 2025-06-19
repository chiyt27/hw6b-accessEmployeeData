package chiyt;

public class DatabaseProxy implements Database {
    private String filePath;
    private RealDatabase realDatabase;

    public DatabaseProxy(String filePath) {
        this.filePath = filePath;
    }

    private void lazyInitialization() {
        if(realDatabase==null){
            this.realDatabase = new RealDatabase(filePath);
        }
    }

    @Override
    public Employee getEmployeeById(int id) {
        if(this.realDatabase==null){
            lazyInitialization();
        }
        /*需求B4 密碼保護 (Password Protection)：在存取 RealDatabase 的 getEmployeeId 操作時，
        必須在實際存取前先檢查執行環境變數中 PASSWORD 變數的值，確定該值必須為 1qaz2wsx 後才得以繼續，否則中斷此存取*/
        String password = System.getenv("PASSWORD");
        if ("1qaz2wsx".equals(password)) {
            Employee realEmployee = realDatabase.getEmployeeById(id);
            if (realEmployee != null) {
                return new EmployeeProxy(realEmployee, this); // 返回 EmployeeProxy，以便達成需求B3 延遲載入subordinates清單
            }
            return null;
        } else {
            System.out.println("Access denied: Invalid PASSWORD.");
            return null;
        }
    }
}