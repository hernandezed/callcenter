package com.dispatcher;

import com.callcenter.CallDispatcher;
import com.callcenter.domain.Call;
import com.callcenter.domain.Customer;
import com.callcenter.domain.Operator;
import com.utils.CallUtils;
import com.utils.EmployeeUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Before;
import org.junit.Test;

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
    public void dispatchCall_withTenCall_attendsAllOperator() throws InterruptedException, ExecutionException {
        CallDispatcher callDispatcher = new CallDispatcher(EmployeeUtils.buildBasicCallCenter());
        List<Future<Call>> inProcessCalls = new ArrayList<>();
        List<Call> calls = new ArrayList<>();
        for (Call call : CallUtils.makeTenCalls()) {
            inProcessCalls.add(callDispatcher.dispatchCall(call));
        }
        for (Future<Call> inProcessCall : inProcessCalls) {
            calls.add(inProcessCall.get());
        }
        assertThat(calls).hasSize(10).doesNotContainNull();
    }

}
