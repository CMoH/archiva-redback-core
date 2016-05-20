package org.apache.archiva.redback.integration.model;

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

import org.apache.archiva.redback.rbac.Permission;
import org.apache.archiva.redback.rbac.Role;

/**
 * EditRoleDetails - Existing user Role Details.
 *
 * This is a placeholder for information passed back
 * and forth between the Action and the Client.
 *
 * We intentionally do not hook up the actual object to prevent
 * creative injection of fields and values by the untrusted client.
 *
 * @author <a href="mailto:joakim@erdfelt.com">Joakim Erdfelt</a>
 *
 */
public class EditRoleDetails
    extends RoleDetails
{
    public EditRoleDetails( Role role )
    {
        super.setName( role.getName() );
        super.setDescription( role.getDescription() );
        
        for ( String r : role.getChildRoleNames() )
        {
            super.addChildRoleName( r );
        }

        for ( Permission perm : role.getPermissions() )
        {
            super.addPermission( perm.getName(), perm.getOperation().getName(), perm.getResource().getIdentifier() );
        }
    }

    public void setName( String name )
    {
        // Prevent Change (This is an edit after all)
    }
}
