package biz;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FormNode {

    private String path;

    private Object data;

    private List<FormNode> children;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public List<FormNode> getChildren() {
        return children;
    }

    public void setChildren(List<FormNode> children) {
        this.children = children;
    }


    public static FormNode find(FormNode template, String path) {
        String[] indexes = path.split("_");

        FormNode p = template;
        for (int i = 1; i < indexes.length; i++) {
            String index = indexes[i];
            Map<String, FormNode> childrenMap = p.getChildren().stream().collect(Collectors.toMap(FormNode::getPath, Function.identity()));
            if (!childrenMap.containsKey(index)) {
                return null;
            }
            p = childrenMap.get(index);
        }
        return p;
    }

    public static void main(String[] args) {
        FormNode template = new FormNode();
        template.setPath("模板一");

        FormNode form1 = new FormNode();
        form1.setPath("模板A");

        FormNode data1 = new FormNode();
        data1.setPath("数据单元a1");
        FormNode data2 = new FormNode();
        data2.setData("Hello");
        data2.setPath("数据单元a2");

        form1.setChildren(List.of(data1, data2));

        FormNode form2 = new FormNode();
        form2.setPath("表单B");
        template.setChildren(List.of(form1, form2));

        FormNode result = find(template, "模板一_模板A_数据单元a2");
        System.out.println(result.getData()); // Hello
    }

}
