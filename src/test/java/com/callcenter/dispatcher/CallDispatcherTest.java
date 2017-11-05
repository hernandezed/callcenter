package com.callcenter.dispatcher;

import com.callcenter.domain.Call;
import com.callcenter.domain.Operator;
import com.callcenter.util.CallUtils;
import java.util.concurrent.PriorityBlockingQueue;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import org.junit.Before;
import org.junit.Test;

public class CallDispatcherTest {

    private CallDispatcher callDispatcher;

    @Before
    public void setUp() {
        callDispatcher = new CallDispatcher(new PriorityBlockingQueue<>(10));
    }

    @Test
    public void dispatchCall_onlyOneCall_attendsAnOperator() {
        Call call = CallUtils.createSimpleCall();
        callDispatcher.dispatchCall(call);

        assertThat(call).hasNoNullFieldsOrProperties();
        assertThat(call.getEmployee()).isInstanceOf(Operator.class);
        assertThat(call.getDuration()).isBetween(5, 10);

    }

}
