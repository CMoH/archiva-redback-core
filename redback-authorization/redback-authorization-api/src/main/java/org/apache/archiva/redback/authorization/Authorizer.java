package org.apache.archiva.redback.authorization;

/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

import org.apache.archiva.redback.authorization.AuthorizationDataSource;
import org.apache.archiva.redback.authorization.AuthorizationException;
import org.apache.archiva.redback.authorization.AuthorizationResult;

/**
 * Authorizer:
 *
 * @author: Jesse McConnell
 * TODO chain of command rule processing
 */
public interface Authorizer
{
    String getId();

    /**
     *
     * @param source
     * @return result of authorization check can be <code>null</code>
     * @throws AuthorizationException
     */
    AuthorizationResult isAuthorized( AuthorizationDataSource source )
        throws AuthorizationException;

    /**
     * @return true if this implementation is a final one and not a wrapper
     * @since 2.1
     */
    boolean isFinalImplementation();

    /**
     * @return a key to be able to customize label in UI
     * @since 2.1
     */
    String getDescriptionKey();
}
