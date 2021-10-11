import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class myBatisDelete { 

   public static void main(String args[]) throws IOException{
      
      Reader reader = Resources.getResourceAsReader("SqlMapConfig.xml");
      SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);		
      SqlSession session = sqlSessionFactory.openSession(); 
	  
      //Delete operation
      deleteStudent(session);
   }

	private static void deleteStudent(SqlSession session) {
		  session.delete("Student.deleteById", 1);     
	      session.commit();
	      session.close();      
	      System.out.println("Record deleted successfully");
	}
}