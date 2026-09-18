package com.gbank.function;

import com.microsoft.azure.functions.ExecutionContext;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.annotation.ServiceBusQueueTrigger;

public class FraudProcessingFunction {

    @FunctionName("FraudProcessingFunction")
    public void run(
            @ServiceBusQueueTrigger(
                    name = "message",
                    queueName = "fraud-processing-queue",
                    connection = "ServiceBusConnection"
            )
            String message,
            final ExecutionContext context) {

        context.getLogger().info("Fraud message received:");

        context.getLogger().info(message);
    }
}