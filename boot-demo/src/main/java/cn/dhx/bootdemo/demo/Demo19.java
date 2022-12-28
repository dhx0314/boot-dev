package cn.dhx.bootdemo.demo;



import java.util.*;

public class Demo19 {




    private static  LinkedHashMap<String, ArrayList<IpFragmentPacket>> sipUdpFragmentCache = new LinkedHashMap<>(2000);

    public static void main(String[] args) throws Exception {
        IpFragmentPacket ipFragmentPacket = new IpFragmentPacket();
        ArrayList<IpFragmentPacket> ipFragmentPackets = new ArrayList<>();
        ipFragmentPackets.add(ipFragmentPacket);
        ipFragmentPackets.add(ipFragmentPacket);
        ipFragmentPackets.add(ipFragmentPacket);
        System.out.println(ipFragmentPackets.size());

        for (int i = 0; i < 12; i++) {

            int size = sipUdpFragmentCache.size();
            System.out.println(size);
            if (size > 4) {
//                sipUdpFragmentCache.entrySet().iterator().remove();
                sipUdpFragmentCache.forEach((k,v)->{
                    System.out.println(k);
                });

                Iterator<Map.Entry<String, ArrayList<IpFragmentPacket>>> iterator = sipUdpFragmentCache.entrySet().iterator();
                if (iterator.hasNext()) {
                    iterator.next();
                    iterator.remove();
                }

                System.out.println("--"+sipUdpFragmentCache.size());

            }
            sipUdpFragmentCache.put("aa"+i,ipFragmentPackets);
            if (sipUdpFragmentCache.size() == 5) {
                sipUdpFragmentCache.forEach((k,v)->{
                    System.out.println(k);
                });
                System.out.println("------");
            }

        }


    }


}


/**
 * IP/UDP分片分段处理
 */
class IpFragmentPacket {
    /**
     * 格式 : srcIP->dstIP|ID
     * 如  : 172.16.1.111->172.16.1.10|12345
     */
    private  String uniqueKey;
    private  String srcIp;
    private  String dstIp;
    private  int identification; // 唯一ID
    private  boolean moreFragmentsFlag; // 更多分片标志，true-有，false-没有
    private  Map<Integer, byte[]> payloads = new HashMap<>();
    private int contentLength;
    /**
     * offset : 偏移量
     * 这个字段表示的是分片在正个数据报中的相对位置，以8字节为单位。通过这个字段，目的主机可以根据
     * 分片偏移的值从第一个分片开始组装到最后一个分片，直至形成一个完整的IP数据报。
     * <p>
     * 1) 分片偏移为0的分片是第一个分片
     * 2) 把第一个分片的长度除以8得到第二个分片的偏移值，于是目的主机从接收到的分片中寻找该分片偏移
     * 值的分片，组装第二个分片
     * 3) 把第一个分片和第二个分片的长度除以8得到第三个分片的偏移值，于是目的主机从接收到的分片中找
     * 到该分片，这样就把前三个分片组装好了
     * 4) 继续以上过程，直到最后的一个分片的还有分片的值为0
     */
    private  int offset;
    private List<Integer> expectedOffsets;

    public IpFragmentPacket() {
    }

//    private IpFragmentPacket(IpV4Packet ipv4Packet) {
//        IpV4Packet.IpV4Header header = ipv4Packet.getHeader();
//        this.srcIp = header.getSrcAddr().getHostAddress();
//        this.dstIp = header.getDstAddr().getHostAddress();
//        this.identification = header.getIdentificationAsInt();
//        this.uniqueKey = String.format("%s->%s|%s", srcIp, dstIp, identification);
//        this.moreFragmentsFlag = header.getMoreFragmentFlag();
//        this.offset = (header.getFragmentOffset() & 0xFFFF) * 8;
//        this.contentLength = ipv4Packet.getPayload().length();
//        if (ipv4Packet.getPayload() != null) {
//            this.payloads.put(offset, ipv4Packet.getPayload().getRawData());
//        }
//    }

    /**
     * 将当前的IP分包合并到旧的包中，并更新相应属性。
     *
     * @param newPacket
     * @return 如果所有的分包都已合并完成，即expectedOffsets size为0，则返回true。
     */
    private boolean completeMergePacket(IpFragmentPacket newPacket) {
        if (this.expectedOffsets == null) {
            this.expectedOffsets = new LinkedList<>();
            if (offset > 0) {
                expectedOffsets.add(0);
                expectedOffsets.add(offset);
            }
            if (moreFragmentsFlag) {
                int nextOffset = offset + contentLength;
                expectedOffsets.add(nextOffset);
            }
        }

        if (newPacket != null) {
            this.payloads.putAll(newPacket.payloads);
            this.contentLength += newPacket.contentLength;
            Integer offset = newPacket.offset; // 注意要用Integer,而不是int！
            if (this.expectedOffsets.contains(offset)) {
                this.expectedOffsets.remove(offset);
            } else {
                this.expectedOffsets.add(offset);
            }
            Integer nextOffset = newPacket.offset + newPacket.contentLength; // 注意要用Integer,而不是int！
            if (this.expectedOffsets.contains(nextOffset)) {
                this.expectedOffsets.remove(nextOffset);
            } else if (newPacket.moreFragmentsFlag) {
                this.expectedOffsets.add(nextOffset);
            }
        }
        return this.expectedOffsets.size() == 0;
    }
}
