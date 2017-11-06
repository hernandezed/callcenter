package com.dispatcher;

import com.callcenter.CallDispatcher;
import com.callcenter.EmployeeUtils;
import com.callcenter.domain.Call;
import com.callcenter.domain.Customer;
import com.callcenter.domain.Operator;
import com.utils.CallUtils;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest(Thread.class)
public class CallDispatcherTest {

    private CallDispatcher callDispatcher;

    @Before
    public void setUp() throws Exception {
        callDispatcher = new CallDispatcher(EmployeeUtils.buildBasicCallCenter());
    }

    @Test
    public void dispatchCall_onlyOneCall_attendsAnOperator() {
        Call call = new Call(new Customer("Maria", "123123123"));
        callDispatcher.dispatchCall(call);

        assertThat(call).hasNoNullFieldsOrProperties();
        assertThat(call.getEmployee()).isInstanceOf(Operator.class);
        assertThat(call.getDuration()).isBetween(5, 10);
    }

    @Test
    public void adispatchCall_onlyOneCall_attendsAnOperator() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(10);
        CallDispatcher callDispatcher = new CallDispatcher(EmployeeUtils.buildBasicCallCenter());

        List<Call> calls = CallUtils.makeTenCalls();
        for (Call call : calls) {
            callDispatcher.dispatchCall(call);
        }
        latch.await();
        assertThat(calls.get(0)).hasNoNullFieldsOrProperties();
        assertThat(calls.get(0).getEmployee()).isInstanceOf(Operator.class);
        assertThat(calls.get(0).getDuration()).isBetween(5, 10);
    }

}
