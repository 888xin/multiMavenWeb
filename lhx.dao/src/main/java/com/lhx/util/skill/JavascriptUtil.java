package com.lhx.util.skill;

import javax.script.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * Created by lhx on 2016/10/11 9:37
 *
 * @Description 动态加载javascript脚本文件来执行，不用重启main函数，只要修改javascript文件，过一段时间
 *，代码就会生效了！
 */
public class JavascriptUtil {

    public static void main(String[] args) throws FileNotFoundException, ScriptException, NoSuchMethodException {
        //获得一个javascript的执行引擎
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("javascript");
        //建立上下文变量
        Bindings bind = engine.createBindings();
        bind.put("factor", 1);
        //绑定上下文，作用域是当前引擎范围
        engine.setBindings(bind, ScriptContext.ENGINE_SCOPE);
        Scanner input = new Scanner(System.in);
        while (input.hasNextInt()){
            int first = input.nextInt();
            int sec = input.nextInt();
            System.out.println("输入参数是：" + first + "，" + sec);
            //执行js代码
            engine.eval(new FileReader("C:\\Users\\Lifeix\\Documents\\IdeaProjects\\multiMavenWeb\\lhx.dao\\src\\main\\java\\com\\lhx\\util\\skill\\model.js"));
            if (engine instanceof Invocable){
                Invocable in = (Invocable) engine;
                //执行js中的函数
                Double result = (Double) in.invokeFunction("formula", first, sec);
                System.out.println(" 运行结果：" + result.intValue());
            }
        }


    }
}
