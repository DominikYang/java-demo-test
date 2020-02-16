import com.sun.codemodel.JCodeModel;
import org.jsonschema2pojo.*;
import org.jsonschema2pojo.rules.RuleFactory;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;

/**
 * @author Wei yuyaung
 * @date 2020.02.16 18:53
 */
public class JsonSchema2PojoTest {
    public static void main(String[] args) {
        JCodeModel codeModel = new JCodeModel();

        URL source = JsonSchema2PojoTest.class.getResource("/schema/required.json");

        GenerationConfig config = new DefaultGenerationConfig() {
            @Override
            public boolean isGenerateBuilders() { // set config option by overriding method
                return true;
            }


        };

        SchemaMapper mapper = new SchemaMapper(new RuleFactory(config, new Jackson2Annotator(config), new SchemaStore()), new SchemaGenerator());
        mapper.generate(codeModel, "ClassName", "com.required", source);

        try {
            codeModel.build(Files.createTempDirectory("required").toFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
