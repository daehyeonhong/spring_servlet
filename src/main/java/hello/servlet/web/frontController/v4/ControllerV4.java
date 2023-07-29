package hello.servlet.web.frontController.v4;

import java.util.Map;

public interface ControllerV4 {
    /**
     * @param parameterMap: key = 파라미터 이름, value = 파라미터 값
     * @param model:        뷰에 전달할 데이터 모델
     * @return viewName
     */
    String process(final Map<String, String> parameterMap, final Map<String, Object> model);
}
