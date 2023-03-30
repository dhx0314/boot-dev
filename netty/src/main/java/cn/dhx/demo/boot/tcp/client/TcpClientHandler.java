/*
 * Copyright 2012 The Netty Project
 *
 * The Netty Project licenses this file to you under the Apache License,
 * version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at:
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */
package cn.dhx.demo.boot.tcp.client;

import io.netty.channel.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;


@Slf4j
@Component
@ChannelHandler.Sharable
public class TcpClientHandler extends SimpleChannelInboundHandler<byte[]> {

//
//    @Autowired
//    private TcpClient client;

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        log.info("tcp channelActive id {}",ctx.channel().id());
    }

//    @Override
//    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
//
//
//       log.info("-----");
//
//        byte[] bytes2= (byte[]) msg;
//        String body2 = new String(bytes2, "UTF-8");
//        log.info("---{}",body2);
////        ByteBuf buf = (ByteBuf) msg;
////        byte[] req = new byte[buf.readableBytes()];
////        buf.readBytes(req);
////        String body = new String(req, "UTF-8");
////        System.out.println("Now is : " + body);
////        log.info("Now is : " + body);
//    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, byte[] msg) throws Exception {
        String body2 = new String(msg, "UTF-8");
        log.info("--channelRead0-{}",body2);
    }



    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        log.info("tcp exceptionCaught id {}",ctx.channel().id());
        ctx.close();
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) {
        log.info("tcp channelInactive id {}",ctx.channel().id());
        ctx.close();
//        client.doConnect();
    }

}
