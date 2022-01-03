package test;

import com.example.demo.DemoApplication;
import com.example.demo.entity.User;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.common.unit.TimeValue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

/**
 * @author liminghao.
 * @date 2022/1/3
 * @time 16:02
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { DemoApplication.class })
public class ElasticSearchClientConfigTest {

    @Autowired
    private RestHighLevelClient restHighLevelClient;

    //测试索引创建
    @Test
    public void restHighLevelClient() throws IOException {
        // 1.创建索引请求
        CreateIndexRequest request = new CreateIndexRequest("kuang_index");
        // 2.客户端执行请求、IndicesClient,请求后获得响应
        CreateIndexResponse createIndexResponse =
                restHighLevelClient.indices().create(request, RequestOptions.DEFAULT);
        System.out.println(createIndexResponse);
    }

    // 测试获取索引,判断索引是否存在
    @Test
    public void testExistIndex() throws IOException {
        GetIndexRequest request = new GetIndexRequest("min_index");
        boolean exists = restHighLevelClient.indices().exists(request, RequestOptions.DEFAULT);
        System.out.println(exists);
    }

    // 测试删除索引
    @Test
    public void testDeleteIndex() throws IOException {
        DeleteIndexRequest request = new DeleteIndexRequest("kuang_index");
        AcknowledgedResponse delete = restHighLevelClient.indices()
                .delete(request, RequestOptions.DEFAULT);
        System.out.println(delete.isAcknowledged());
    }

    // 测试添加文档
    void testAddDocument() {
        // 创建对象
        User user = new User();
        user.setUsername("张三");
        user.setPassword("12345");

        // 创建请求
        IndexRequest request = new IndexRequest("kuang_index");

        // 规则 put /kuang_index/_doc/1
        request.id("1");
        request.timeout(TimeValue.timeValueSeconds(1));
        request.timeout("1s");
    }
}
