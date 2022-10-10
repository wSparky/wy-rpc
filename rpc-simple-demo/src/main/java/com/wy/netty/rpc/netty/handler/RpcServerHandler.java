package com.wy.netty.rpc.netty.handler;

import com.wy.netty.rpc.constant.ReqType;
import com.wy.netty.rpc.protocol.Header;
import com.wy.netty.rpc.protocol.RpcProtocol;
import com.wy.netty.rpc.protocol.RpcRequest;
import com.wy.netty.rpc.protocol.RpcResponse;
import com.wy.netty.rpc.netty.spring.SpringBeanManager;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/**
 *
 * @author wangye
 * @date 2022/10/10 14:06
 * @Email wangye.wy@outlook.com
 * @Description 服务端事件处理器
 */

public class RpcServerHandler extends SimpleChannelInboundHandler<RpcProtocol<RpcRequest>> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, RpcProtocol<RpcRequest> msg) throws Exception {
        RpcProtocol<RpcResponse> resProtocol = new RpcProtocol<>();
        //处理服务端返回的对象
        Header header = msg.getHeader();
        header.setReqType(ReqType.RESPONSE.code());

        //通过反射调用方法
        Object result = invoke(msg.getContent());

        resProtocol.setHeader(header);

        RpcResponse response = new RpcResponse();
        response.setData(result);
        response.setMsg("success");

        resProtocol.setContent(response);

        ctx.writeAndFlush(resProtocol);
    }

    //通过反射进行调用
    private Object invoke(RpcRequest request){
        try{
            //反射加载
            Class<?> clazz = Class.forName(request.getClassName());
            //加载实例
            Object bean = SpringBeanManager.getBean(clazz);
            //加载实例调用的方法
            Method method = clazz.getDeclaredMethod(request.getMethodName(),request.getParamsTypes());
            //通过反射调用
            return method.invoke(bean,request.getParams());

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
}
