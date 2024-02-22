package com.demo.testvone.work;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.flowable.action.api.bot.BaseBotActionResult;
import com.flowable.action.api.bot.BotActionResult;
import com.flowable.action.api.bot.BotService;
import com.flowable.action.api.history.HistoricActionInstance;
import com.flowable.action.api.intents.Intent;
import com.flowable.action.api.repository.ActionDefinition;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.runtime.ProcessInstance;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class FakeUserBot implements BotService {

    private final RuntimeService runtimeService;

    public FakeUserBot(RuntimeService runtimeService) {
        this.runtimeService = runtimeService;
    }

    @Override
    public String getKey() {
        return "fake-user-bot";
    }

    @Override
    public String getName() {
        return "Fake User Bot";
    }

    @Override
    public String getDescription() {
        return "Bot to create a random user";
    }

    @Override
    public BotActionResult invokeBot(HistoricActionInstance actionInstance,
                                     ActionDefinition actionDefinition,
                                     Map<String, Object> payload) {
        ProcessInstance processInstance = runtimeService.createProcessInstanceBuilder()
                .processDefinitionKey("DA_P001")
                .start();

        if (processInstance.isEnded()) {
            JsonNode response = new ObjectMapper().valueToTree(processInstance.getProcessVariables());
            return new BaseBotActionResult( response, Intent.NOOP);
        }

        return null;
    }
}
