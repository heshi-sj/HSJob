package server;

import java.io.InputStream;
import java.net.Socket;
import java.util.List;
import java.util.Map;

public class RequestProcessor extends Thread {

    private Socket socket;
    private Mapper mapper;

    public RequestProcessor(Socket socket, Mapper mapper) {
        this.socket = socket;
        this.mapper = mapper;
    }

    @Override
    public void run() {
        try{
            InputStream inputStream = socket.getInputStream();

            // 封装Request对象和Response对象
            HttpServlet httpServlet = null;
            Request request = new Request(inputStream);
            Response response = new Response(socket.getOutputStream());
            List<Context> contextList = mapper.getHostList().get(0).getContextList();
            String[] urlArray = request.getUrl().split("/");
            for(Context context : contextList) {
                if (context.getAppname().equals(urlArray[1])) {
                    List<Wrapper> wrapperList = context.getWrapperList();
                    for(Wrapper wrapper : wrapperList){
                        if(wrapper.getUrlPath().replace("/","").equals(urlArray[2])){
                            httpServlet = wrapper.getServlet();
                        }
                    }
                }
            }

            // 静态资源处理
            if(httpServlet == null) {
                response.outputHtml(request.getUrl());
            }else{
                // 动态资源servlet请求
                httpServlet.service(request,response);
            }

            socket.close();

        }catch (Exception e) {
            e.printStackTrace();
        }

    }
}
