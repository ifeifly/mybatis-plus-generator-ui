import com.github.davidfantasy.mybatisplus.generatorui.GeneratorConfig;
import com.github.davidfantasy.mybatisplus.generatorui.MybatisPlusToolsApplication;
import com.github.davidfantasy.mybatisplus.generatorui.mbp.NameConverter;

public class TestApplication {


    public static void main(String[] args) {
        GeneratorConfig config = GeneratorConfig.builder().jdbcUrl("jdbc:mysql://81.69.21.219:3306/flyingmall_OrderDB")
                .userName("root")
                .password("Df@root.!123")
                .port(8068)
                .driverClassName("com.mysql.cj.jdbc.Driver")
                .basePackage("com.github.davidfantasy.mybatisplus.generatorui.example")
                .nameConverter(new NameConverter() {
                    @Override
                    public String serviceNameConvert(String tableName) {
                        return this.entityNameConvert(tableName) + "Service";
                    }

                    @Override
                    public String controllerNameConvert(String tableName) {
                        return this.entityNameConvert(tableName) + "controller";
                    }
                })
                .build();
        MybatisPlusToolsApplication.run(config);
    }


}
