
class FileNode extends FileSysNode {
    @SuppressWarnings("unused")
    FileNode(String name){
        super(name);
    }
    @Override
    void display(){
    System.out.println("File: " + name);
    }
}
