/**
 * Copyright 2020-9999 the original author or authors.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.mykit.transaction.message.demo.springcloud.order.client;

import io.mykit.transaction.message.annotation.MykitTransactionMessage;
import io.mykit.transaction.message.demo.springcloud.account.api.dto.AccountDto;
import io.mykit.transaction.message.demo.springcloud.account.api.entity.AccountDo;
import io.mykit.transaction.message.demo.springcloud.account.api.service.AccountService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author binghe
 * @version 1.0.0
 * @description AccountClient
 */
@FeignClient(value = "account-service")
public interface AccountClient {

    /**
     * 用户账户付款
     *
     * @param accountDto 实体类
     * @return true 成功
     */
    @RequestMapping("/account-service/account/payment")
    @MykitTransactionMessage(destination = "account", target = AccountService.class)
    Boolean payment(@RequestBody AccountDto accountDto);


    /**
     * 获取用户账户信息
     *
     * @param userId 用户id
     * @return AccountDO account do
     */
    @RequestMapping("/account-service/account/findByUserId")
    AccountDo findByUserId(@RequestParam("userId") String userId);
}
