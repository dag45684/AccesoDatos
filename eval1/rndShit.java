package AccesoDatos.eval1;

public class rndShit {

    public static void main(String[] args) {
        Person p = new Person();
        try{
            p.setAge(400);
        } catch (PersonException err){
            System.out.println(err.getMessage());
        }

    }


}
