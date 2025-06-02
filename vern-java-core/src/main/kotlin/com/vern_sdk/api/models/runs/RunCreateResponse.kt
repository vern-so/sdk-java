// File generated from our OpenAPI spec by Stainless.

package com.vern_sdk.api.models.runs

import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.vern_sdk.api.core.ExcludeMissing
import com.vern_sdk.api.core.JsonField
import com.vern_sdk.api.core.JsonMissing
import com.vern_sdk.api.core.JsonValue
import com.vern_sdk.api.core.toImmutable
import com.vern_sdk.api.errors.VernInvalidDataException
import java.time.OffsetDateTime
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

class RunCreateResponse
private constructor(
    private val id: JsonField<String>,
    private val inputs: JsonField<Inputs>,
    private val queuedAt: JsonField<OffsetDateTime>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("id") @ExcludeMissing id: JsonField<String> = JsonMissing.of(),
        @JsonProperty("inputs") @ExcludeMissing inputs: JsonField<Inputs> = JsonMissing.of(),
        @JsonProperty("queued_at")
        @ExcludeMissing
        queuedAt: JsonField<OffsetDateTime> = JsonMissing.of(),
    ) : this(id, inputs, queuedAt, mutableMapOf())

    /**
     * Unique identifier for the run
     *
     * @throws VernInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun id(): Optional<String> = id.getOptional("id")

    /**
     * The inputs provided for the task
     *
     * @throws VernInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun inputs(): Optional<Inputs> = inputs.getOptional("inputs")

    /**
     * Timestamp when the run was queued
     *
     * @throws VernInvalidDataException if the JSON field has an unexpected type (e.g. if the server
     *   responded with an unexpected value).
     */
    fun queuedAt(): Optional<OffsetDateTime> = queuedAt.getOptional("queued_at")

    /**
     * Returns the raw JSON value of [id].
     *
     * Unlike [id], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("id") @ExcludeMissing fun _id(): JsonField<String> = id

    /**
     * Returns the raw JSON value of [inputs].
     *
     * Unlike [inputs], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("inputs") @ExcludeMissing fun _inputs(): JsonField<Inputs> = inputs

    /**
     * Returns the raw JSON value of [queuedAt].
     *
     * Unlike [queuedAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("queued_at") @ExcludeMissing fun _queuedAt(): JsonField<OffsetDateTime> = queuedAt

    @JsonAnySetter
    private fun putAdditionalProperty(key: String, value: JsonValue) {
        additionalProperties.put(key, value)
    }

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> =
        Collections.unmodifiableMap(additionalProperties)

    fun toBuilder() = Builder().from(this)

    companion object {

        /** Returns a mutable builder for constructing an instance of [RunCreateResponse]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [RunCreateResponse]. */
    class Builder internal constructor() {

        private var id: JsonField<String> = JsonMissing.of()
        private var inputs: JsonField<Inputs> = JsonMissing.of()
        private var queuedAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(runCreateResponse: RunCreateResponse) = apply {
            id = runCreateResponse.id
            inputs = runCreateResponse.inputs
            queuedAt = runCreateResponse.queuedAt
            additionalProperties = runCreateResponse.additionalProperties.toMutableMap()
        }

        /** Unique identifier for the run */
        fun id(id: String) = id(JsonField.of(id))

        /**
         * Sets [Builder.id] to an arbitrary JSON value.
         *
         * You should usually call [Builder.id] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun id(id: JsonField<String>) = apply { this.id = id }

        /** The inputs provided for the task */
        fun inputs(inputs: Inputs) = inputs(JsonField.of(inputs))

        /**
         * Sets [Builder.inputs] to an arbitrary JSON value.
         *
         * You should usually call [Builder.inputs] with a well-typed [Inputs] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun inputs(inputs: JsonField<Inputs>) = apply { this.inputs = inputs }

        /** Timestamp when the run was queued */
        fun queuedAt(queuedAt: OffsetDateTime) = queuedAt(JsonField.of(queuedAt))

        /**
         * Sets [Builder.queuedAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.queuedAt] with a well-typed [OffsetDateTime] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun queuedAt(queuedAt: JsonField<OffsetDateTime>) = apply { this.queuedAt = queuedAt }

        fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
            this.additionalProperties.clear()
            putAllAdditionalProperties(additionalProperties)
        }

        fun putAdditionalProperty(key: String, value: JsonValue) = apply {
            additionalProperties.put(key, value)
        }

        fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
            this.additionalProperties.putAll(additionalProperties)
        }

        fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

        fun removeAllAdditionalProperties(keys: Set<String>) = apply {
            keys.forEach(::removeAdditionalProperty)
        }

        /**
         * Returns an immutable instance of [RunCreateResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): RunCreateResponse =
            RunCreateResponse(id, inputs, queuedAt, additionalProperties.toMutableMap())
    }

    private var validated: Boolean = false

    fun validate(): RunCreateResponse = apply {
        if (validated) {
            return@apply
        }

        id()
        inputs().ifPresent { it.validate() }
        queuedAt()
        validated = true
    }

    fun isValid(): Boolean =
        try {
            validate()
            true
        } catch (e: VernInvalidDataException) {
            false
        }

    /**
     * Returns a score indicating how many valid values are contained in this object recursively.
     *
     * Used for best match union deserialization.
     */
    @JvmSynthetic
    internal fun validity(): Int =
        (if (id.asKnown().isPresent) 1 else 0) +
            (inputs.asKnown().getOrNull()?.validity() ?: 0) +
            (if (queuedAt.asKnown().isPresent) 1 else 0)

    /** The inputs provided for the task */
    class Inputs
    @JsonCreator
    private constructor(
        @com.fasterxml.jackson.annotation.JsonValue
        private val additionalProperties: Map<String, JsonValue>
    ) {

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        companion object {

            /** Returns a mutable builder for constructing an instance of [Inputs]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Inputs]. */
        class Builder internal constructor() {

            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(inputs: Inputs) = apply {
                additionalProperties = inputs.additionalProperties.toMutableMap()
            }

            fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.clear()
                putAllAdditionalProperties(additionalProperties)
            }

            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                additionalProperties.put(key, value)
            }

            fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.putAll(additionalProperties)
            }

            fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

            fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                keys.forEach(::removeAdditionalProperty)
            }

            /**
             * Returns an immutable instance of [Inputs].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Inputs = Inputs(additionalProperties.toImmutable())
        }

        private var validated: Boolean = false

        fun validate(): Inputs = apply {
            if (validated) {
                return@apply
            }

            validated = true
        }

        fun isValid(): Boolean =
            try {
                validate()
                true
            } catch (e: VernInvalidDataException) {
                false
            }

        /**
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic
        internal fun validity(): Int =
            additionalProperties.count { (_, value) -> !value.isNull() && !value.isMissing() }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return /* spotless:off */ other is Inputs && additionalProperties == other.additionalProperties /* spotless:on */
        }

        /* spotless:off */
        private val hashCode: Int by lazy { Objects.hash(additionalProperties) }
        /* spotless:on */

        override fun hashCode(): Int = hashCode

        override fun toString() = "Inputs{additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is RunCreateResponse && id == other.id && inputs == other.inputs && queuedAt == other.queuedAt && additionalProperties == other.additionalProperties /* spotless:on */
    }

    /* spotless:off */
    private val hashCode: Int by lazy { Objects.hash(id, inputs, queuedAt, additionalProperties) }
    /* spotless:on */

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "RunCreateResponse{id=$id, inputs=$inputs, queuedAt=$queuedAt, additionalProperties=$additionalProperties}"
}
