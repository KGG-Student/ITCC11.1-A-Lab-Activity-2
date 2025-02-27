
import java.util.ArrayList;
import java.util.List;

public class DirectoryNode extends FileSysNode {
     List<FileSysNode> children;

     DirectoryNode(String name){
      super(name);
      children = new ArrayList<>();
     }
     
     void addchild(FileSysNode child){
      children.add(child);
     }
     @Override
     void display(){
      System.out.println("Directory Name:" + name);
      for
      (FileSysNode child : children){
         child.display();
        }
     }
}
