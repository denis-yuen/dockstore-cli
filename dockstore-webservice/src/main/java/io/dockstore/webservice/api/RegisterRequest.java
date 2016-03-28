/*
 *    Copyright 2016 OICR
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package io.dockstore.webservice.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;

/**
 * This is an object to encapsulate a register request in an entity. Does not need to be stored in the database. Used for the body of
 * /containers/{containerId}/register
 *
 * @author xliu
 */
@ApiModel("RegisterRequest")
public class RegisterRequest {
    private boolean register;

    public RegisterRequest() {
    }

    public RegisterRequest(boolean register) {
        this.register = register;
    }

    @JsonProperty
    public boolean getRegister() {
        return register;
    }
}