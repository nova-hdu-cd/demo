package com.chendong.demo.helper;

import com.chendong.demo.common.enums.KunlunTicketStatus;
import com.chendong.demo.common.enums.TicketStatusEnum;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.TreeSet;

/**
 * @author chendong
 * @date 2020/8/29 2:44 下午
 * To change this template use Appearance | Editor | File and Code
 * Templates.
 */
public class DemoHelper {

    public KunlunTicketStatus ticketConvert(TicketStatusEnum status) {
        switch (status) {
            case PENDING:
            case IN_PROGRESS:
                return KunlunTicketStatus.PROCESSING;
            case CLOSED:
            case EVALUATED:
            case COMMENTS_EVALUATION:
                return KunlunTicketStatus.SOLVED;
            case REVOKE:
                return KunlunTicketStatus.CANCELED;
            case WAITING_ASSIGN:
            default:
                return KunlunTicketStatus.UNSOLVED;
        }
    }

    public static void main(String[] args) {
        DemoHelper demoHelper = new DemoHelper();
        //System.out.println(demoHelper.ticketConvert(TicketStatusEnum.CLOSED).getId());

        int[] src = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        int[] dest = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0};

        System.arraycopy(src, 0, dest, 0, src.length);

        System.out.println(Arrays.toString(dest));

        TreeSet<Integer> dui = new TreeSet<>();
        dui.add(1);
        dui.add(2);
        dui.add(3);

        System.out.println(dui.pollFirst());
        System.out.println(dui.pollLast());

        //小顶堆
        PriorityQueue<Object> minHeap = new PriorityQueue<>();

        //大顶堆
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);

    }


}
