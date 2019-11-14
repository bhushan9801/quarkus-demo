package com.helios.quarkus.demo

import io.quarkus.test.junit.NativeImageTest

@NativeImageTest
open class NativeMetricsResourceIT : MetricsResourceTest()