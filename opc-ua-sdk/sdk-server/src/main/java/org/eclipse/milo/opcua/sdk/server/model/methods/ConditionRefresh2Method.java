/*
 * Copyright (c) 2019 the Eclipse Milo Authors
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 */

package org.eclipse.milo.opcua.sdk.server.model.methods;

import org.eclipse.milo.opcua.sdk.core.ValueRanks;
import org.eclipse.milo.opcua.sdk.server.api.methods.AbstractMethodInvocationHandler;
import org.eclipse.milo.opcua.sdk.server.nodes.UaMethodNode;
import org.eclipse.milo.opcua.stack.core.UaException;
import org.eclipse.milo.opcua.stack.core.types.builtin.LocalizedText;
import org.eclipse.milo.opcua.stack.core.types.builtin.NodeId;
import org.eclipse.milo.opcua.stack.core.types.builtin.Variant;
import org.eclipse.milo.opcua.stack.core.types.builtin.unsigned.UInteger;
import org.eclipse.milo.opcua.stack.core.types.structured.Argument;

public abstract class ConditionRefresh2Method extends AbstractMethodInvocationHandler {
    public static final Argument SUBSCRIPTION_ID = new Argument(
        "SubscriptionId",
        NodeId.parse("ns=0;i=288"),
        ValueRanks.Scalar,
        null,
        new LocalizedText("", "The identifier for the suscription to refresh.")
    );

    public static final Argument MONITORED_ITEM_ID = new Argument(
        "MonitoredItemId",
        NodeId.parse("ns=0;i=288"),
        ValueRanks.Scalar,
        null,
        new LocalizedText("", "The identifier for the monitored item to refresh.")
    );

    public ConditionRefresh2Method(UaMethodNode node) {
        super(node);
    }

    @Override
    public Argument[] getInputArguments() {
        return new Argument[]{SUBSCRIPTION_ID, MONITORED_ITEM_ID};
    }

    @Override
    public Argument[] getOutputArguments() {
        return new Argument[]{};
    }

    @Override
    protected Variant[] invoke(AbstractMethodInvocationHandler.InvocationContext context,
                               Variant[] inputValues) throws UaException {
        UInteger subscriptionId = (UInteger) inputValues[0].getValue();
        UInteger monitoredItemId = (UInteger) inputValues[1].getValue();
        invoke(context, subscriptionId, monitoredItemId);
        return new Variant[]{};
    }

    protected abstract void invoke(AbstractMethodInvocationHandler.InvocationContext context,
                                   UInteger subscriptionId, UInteger monitoredItemId) throws UaException;
}
