package jiedan;

public class LinkStringClass {
    private class LinkNode {
        public char data;            //存放一个字符
        public LinkNode next;        //指向下一个结点的指针
        //构造方法
        public LinkNode() {
            next = null;
        }
        //重载构造方法
        public LinkNode(char ch) {
            data = ch;
            next = null;
        }
    }
    public LinkNode head;//头结点
    public int size;//串中字符个数

    //默认构造函数
    public LinkStringClass() {
        head = new LinkNode();//建立头结点
        size = 0;//初始化链串长度为0
    }

    //采用尾插法初始化建立链串
    //遍历cstr的每一个char建立LinkNode后用尾插法插入
    public LinkStringClass(String cstr) {
        head = new LinkNode(cstr.charAt(0));
        size = 1;
        LinkNode cur = head;
        int i = 1;
        while (i < cstr.length()){
            cur.next = new LinkNode(cstr.charAt(i));
            size++;
            i++;
            cur = cur.next;
        }
    }

    //设置第i个结点的data为x
    public void Seti(int i, char x) {
        if (i > size)return;
        LinkNode cur = head;
        while (i > 0){
            cur = cur.next;
            i--;
        }
        cur.data = x;
    }

    //链串拷贝
    public LinkStringClass StrCopy() {
        LinkNode head = this.head;
        LinkStringClass res = new LinkStringClass();
        res.head=head;
        res.size=size;
        return res;
    }

    //显示当前链串的长度和每一个结点的data
    public void Show() {
       LinkNode cur = head;
        System.out.println("长度为："+size);
        while (cur != null){
            System.out.printf(cur.data+" ");
            cur = cur.next;
        }
        System.out.println();
    }

    //串连接
    public LinkStringClass Concat(LinkStringClass t) {
        LinkNode cur = head;
        while (cur.next != null){
            cur = cur.next;
        }
        cur.next = t.head;
        this.size+=t.size;
        return this;
    }

    //查找第i个位置上的结点并返回该结点,等于0为获取头结点
    public LinkNode FindNode(int i) {
        if (i == 0){
            System.out.println(head.data);
            return head;
        }
        if (i > size)return null;
        LinkNode cur = head;
        while (i > 0){
            cur = cur.next;
            i--;
        }
        System.out.println(cur.data);
        return cur;
    }

    //求从i开始的j个字符的子串
    public LinkStringClass SubStr(int i, int j) {
        LinkStringClass res = new LinkStringClass();
        LinkNode cur1= this.head;
        while (i > 0){
            cur1 =cur1.next;
            i--;
        }
        res.head=cur1;
        LinkNode cur = res.head;
        res.size=j;
        while (j > 1){
            j--;
            cur = cur.next;
        }
        cur.next = null;

        return res;
    }

    //在第i个位置之后插入值，i=0时在头部直接插入，i=size时在最后插入
    public LinkStringClass InsStr(int i, LinkStringClass t) {
        LinkNode cur = t.head;
        size+= t.size;
        while (cur.next!=null){
            cur=cur.next;
        }
        if (i == 0){
            cur.next = head;
            head = t.head;

        } else if(i == size){
            LinkNode cur1 = head;
            while (cur1.next!=null){
                cur1=cur1.next;
            }
            cur1.next=t.head;
        }else {
            LinkNode cur1 = head;
            while (i > 1){
                i--;
                cur1 = cur1.next;
            }
            cur.next = cur1.next;
            cur1.next = t.head;
        }
        return this;
    }

    //删除从i个位置开始的连续j个结点
    public LinkStringClass DelStr(int i, int j) {
        size-=j;
        if (i == 0){

            while (j > 0){
                head = head.next;
                j--;
            }
            return this;
        }

        LinkNode cur = head;
        while (i > 0){
            cur = cur.next;
            i--;
        }
        LinkNode cur1 = cur;
        while (j > 0){
            cur1 = cur1.next;
            j--;
        }
        cur.next=cur1.next;
       return this;
    }
}
