//
//  ========================================================================
//  Copyright (c) 1995-2016 Mort Bay Consulting Pty. Ltd.
//  ------------------------------------------------------------------------
//  All rights reserved. This program and the accompanying materials
//  are made available under the terms of the Eclipse Public License v1.0
//  and Apache License v2.0 which accompanies this distribution.
//
//      The Eclipse Public License is available at
//      http://www.eclipse.org/legal/epl-v10.html
//
//      The Apache License v2.0 is available at
//      http://www.opensource.org/licenses/apache2.0.php
//
//  You may elect to redistribute this code under either of these licenses.
//  ========================================================================
//

package org.eclipse.jetty.alpn.java.server;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class CipherSuiteName
{
    public static Optional<String> from(int code)
    {
        return Optional.ofNullable(names.get(code));
    }

    private static Map<Integer, String> names = new HashMap<>();

    static
    {
        /*
         * TLS Cipher Suite names taken from the TLS Cipher Suite Registry at
         * http://www.iana.org/assignments/tls-parameters/tls-parameters.xhtml
         * as of June 2016.
         *
         * Ciphers from 0x0000 to 0x001B have their name starting with "SSL"
         * rather than the official "TLS" for historical reasons.
         */
        mapCipherSuite(0x00, 0x00 , "SSL_NULL_WITH_NULL_NULL");
        mapCipherSuite(0x00, 0x01 , "SSL_RSA_WITH_NULL_MD5");
        mapCipherSuite(0x00, 0x02 , "SSL_RSA_WITH_NULL_SHA");
        mapCipherSuite(0x00, 0x03 , "SSL_RSA_EXPORT_WITH_RC4_40_MD5");
        mapCipherSuite(0x00, 0x04 , "SSL_RSA_WITH_RC4_128_MD5");
        mapCipherSuite(0x00, 0x05 , "SSL_RSA_WITH_RC4_128_SHA");
        mapCipherSuite(0x00, 0x06 , "SSL_RSA_EXPORT_WITH_RC2_CBC_40_MD5");
        mapCipherSuite(0x00, 0x07 , "SSL_RSA_WITH_IDEA_CBC_SHA");
        mapCipherSuite(0x00, 0x08 , "SSL_RSA_EXPORT_WITH_DES40_CBC_SHA");
        mapCipherSuite(0x00, 0x09 , "SSL_RSA_WITH_DES_CBC_SHA");
        mapCipherSuite(0x00, 0x0A , "SSL_RSA_WITH_3DES_EDE_CBC_SHA");
        mapCipherSuite(0x00, 0x0B , "SSL_DH_DSS_EXPORT_WITH_DES40_CBC_SHA");
        mapCipherSuite(0x00, 0x0C , "SSL_DH_DSS_WITH_DES_CBC_SHA");
        mapCipherSuite(0x00, 0x0D , "SSL_DH_DSS_WITH_3DES_EDE_CBC_SHA");
        mapCipherSuite(0x00, 0x0E , "SSL_DH_RSA_EXPORT_WITH_DES40_CBC_SHA");
        mapCipherSuite(0x00, 0x0F , "SSL_DH_RSA_WITH_DES_CBC_SHA");
        mapCipherSuite(0x00, 0x10 , "SSL_DH_RSA_WITH_3DES_EDE_CBC_SHA");
        mapCipherSuite(0x00, 0x11 , "SSL_DHE_DSS_EXPORT_WITH_DES40_CBC_SHA");
        mapCipherSuite(0x00, 0x12 , "SSL_DHE_DSS_WITH_DES_CBC_SHA");
        mapCipherSuite(0x00, 0x13 , "SSL_DHE_DSS_WITH_3DES_EDE_CBC_SHA");
        mapCipherSuite(0x00, 0x14 , "SSL_DHE_RSA_EXPORT_WITH_DES40_CBC_SHA");
        mapCipherSuite(0x00, 0x15 , "SSL_DHE_RSA_WITH_DES_CBC_SHA");
        mapCipherSuite(0x00, 0x16 , "SSL_DHE_RSA_WITH_3DES_EDE_CBC_SHA");
        mapCipherSuite(0x00, 0x17 , "SSL_DH_anon_EXPORT_WITH_RC4_40_MD5");
        mapCipherSuite(0x00, 0x18 , "SSL_DH_anon_WITH_RC4_128_MD5");
        mapCipherSuite(0x00, 0x19 , "SSL_DH_anon_EXPORT_WITH_DES40_CBC_SHA");
        mapCipherSuite(0x00, 0x1A , "SSL_DH_anon_WITH_DES_CBC_SHA");
        mapCipherSuite(0x00, 0x1B , "SSL_DH_anon_WITH_3DES_EDE_CBC_SHA");
        mapCipherSuite(0x00, 0x1E , "TLS_KRB5_WITH_DES_CBC_SHA");
        mapCipherSuite(0x00, 0x1F , "TLS_KRB5_WITH_3DES_EDE_CBC_SHA");
        mapCipherSuite(0x00, 0x20 , "TLS_KRB5_WITH_RC4_128_SHA");
        mapCipherSuite(0x00, 0x21 , "TLS_KRB5_WITH_IDEA_CBC_SHA");
        mapCipherSuite(0x00, 0x22 , "TLS_KRB5_WITH_DES_CBC_MD5");
        mapCipherSuite(0x00, 0x23 , "TLS_KRB5_WITH_3DES_EDE_CBC_MD5");
        mapCipherSuite(0x00, 0x24 , "TLS_KRB5_WITH_RC4_128_MD5");
        mapCipherSuite(0x00, 0x25 , "TLS_KRB5_WITH_IDEA_CBC_MD5");
        mapCipherSuite(0x00, 0x26 , "TLS_KRB5_EXPORT_WITH_DES_CBC_40_SHA");
        mapCipherSuite(0x00, 0x27 , "TLS_KRB5_EXPORT_WITH_RC2_CBC_40_SHA");
        mapCipherSuite(0x00, 0x28 , "TLS_KRB5_EXPORT_WITH_RC4_40_SHA");
        mapCipherSuite(0x00, 0x29 , "TLS_KRB5_EXPORT_WITH_DES_CBC_40_MD5");
        mapCipherSuite(0x00, 0x2A , "TLS_KRB5_EXPORT_WITH_RC2_CBC_40_MD5");
        mapCipherSuite(0x00, 0x2B , "TLS_KRB5_EXPORT_WITH_RC4_40_MD5");
        mapCipherSuite(0x00, 0x2C , "TLS_PSK_WITH_NULL_SHA");
        mapCipherSuite(0x00, 0x2D , "TLS_DHE_PSK_WITH_NULL_SHA");
        mapCipherSuite(0x00, 0x2E , "TLS_RSA_PSK_WITH_NULL_SHA");
        mapCipherSuite(0x00, 0x2F , "TLS_RSA_WITH_AES_128_CBC_SHA");
        mapCipherSuite(0x00, 0x30 , "TLS_DH_DSS_WITH_AES_128_CBC_SHA");
        mapCipherSuite(0x00, 0x31 , "TLS_DH_RSA_WITH_AES_128_CBC_SHA");
        mapCipherSuite(0x00, 0x32 , "TLS_DHE_DSS_WITH_AES_128_CBC_SHA");
        mapCipherSuite(0x00, 0x33 , "TLS_DHE_RSA_WITH_AES_128_CBC_SHA");
        mapCipherSuite(0x00, 0x34 , "TLS_DH_anon_WITH_AES_128_CBC_SHA");
        mapCipherSuite(0x00, 0x35 , "TLS_RSA_WITH_AES_256_CBC_SHA");
        mapCipherSuite(0x00, 0x36 , "TLS_DH_DSS_WITH_AES_256_CBC_SHA");
        mapCipherSuite(0x00, 0x37 , "TLS_DH_RSA_WITH_AES_256_CBC_SHA");
        mapCipherSuite(0x00, 0x38 , "TLS_DHE_DSS_WITH_AES_256_CBC_SHA");
        mapCipherSuite(0x00, 0x39 , "TLS_DHE_RSA_WITH_AES_256_CBC_SHA");
        mapCipherSuite(0x00, 0x3A , "TLS_DH_anon_WITH_AES_256_CBC_SHA");
        mapCipherSuite(0x00, 0x3B , "TLS_RSA_WITH_NULL_SHA256");
        mapCipherSuite(0x00, 0x3C , "TLS_RSA_WITH_AES_128_CBC_SHA256");
        mapCipherSuite(0x00, 0x3D , "TLS_RSA_WITH_AES_256_CBC_SHA256");
        mapCipherSuite(0x00, 0x3E , "TLS_DH_DSS_WITH_AES_128_CBC_SHA256");
        mapCipherSuite(0x00, 0x3F , "TLS_DH_RSA_WITH_AES_128_CBC_SHA256");
        mapCipherSuite(0x00, 0x40 , "TLS_DHE_DSS_WITH_AES_128_CBC_SHA256");
        mapCipherSuite(0x00, 0x41 , "TLS_RSA_WITH_CAMELLIA_128_CBC_SHA");
        mapCipherSuite(0x00, 0x42 , "TLS_DH_DSS_WITH_CAMELLIA_128_CBC_SHA");
        mapCipherSuite(0x00, 0x43 , "TLS_DH_RSA_WITH_CAMELLIA_128_CBC_SHA");
        mapCipherSuite(0x00, 0x44 , "TLS_DHE_DSS_WITH_CAMELLIA_128_CBC_SHA");
        mapCipherSuite(0x00, 0x45 , "TLS_DHE_RSA_WITH_CAMELLIA_128_CBC_SHA");
        mapCipherSuite(0x00, 0x46 , "TLS_DH_anon_WITH_CAMELLIA_128_CBC_SHA");
        mapCipherSuite(0x00, 0x67 , "TLS_DHE_RSA_WITH_AES_128_CBC_SHA256");
        mapCipherSuite(0x00, 0x68 , "TLS_DH_DSS_WITH_AES_256_CBC_SHA256");
        mapCipherSuite(0x00, 0x69 , "TLS_DH_RSA_WITH_AES_256_CBC_SHA256");
        mapCipherSuite(0x00, 0x6A , "TLS_DHE_DSS_WITH_AES_256_CBC_SHA256");
        mapCipherSuite(0x00, 0x6B , "TLS_DHE_RSA_WITH_AES_256_CBC_SHA256");
        mapCipherSuite(0x00, 0x6C , "TLS_DH_anon_WITH_AES_128_CBC_SHA256");
        mapCipherSuite(0x00, 0x6D , "TLS_DH_anon_WITH_AES_256_CBC_SHA256");
        mapCipherSuite(0x00, 0x84 , "TLS_RSA_WITH_CAMELLIA_256_CBC_SHA");
        mapCipherSuite(0x00, 0x85 , "TLS_DH_DSS_WITH_CAMELLIA_256_CBC_SHA");
        mapCipherSuite(0x00, 0x86 , "TLS_DH_RSA_WITH_CAMELLIA_256_CBC_SHA");
        mapCipherSuite(0x00, 0x87 , "TLS_DHE_DSS_WITH_CAMELLIA_256_CBC_SHA");
        mapCipherSuite(0x00, 0x88 , "TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA");
        mapCipherSuite(0x00, 0x89 , "TLS_DH_anon_WITH_CAMELLIA_256_CBC_SHA");
        mapCipherSuite(0x00, 0x8A , "TLS_PSK_WITH_RC4_128_SHA");
        mapCipherSuite(0x00, 0x8B , "TLS_PSK_WITH_3DES_EDE_CBC_SHA");
        mapCipherSuite(0x00, 0x8C , "TLS_PSK_WITH_AES_128_CBC_SHA");
        mapCipherSuite(0x00, 0x8D , "TLS_PSK_WITH_AES_256_CBC_SHA");
        mapCipherSuite(0x00, 0x8E , "TLS_DHE_PSK_WITH_RC4_128_SHA");
        mapCipherSuite(0x00, 0x8F , "TLS_DHE_PSK_WITH_3DES_EDE_CBC_SHA");
        mapCipherSuite(0x00, 0x90 , "TLS_DHE_PSK_WITH_AES_128_CBC_SHA");
        mapCipherSuite(0x00, 0x91 , "TLS_DHE_PSK_WITH_AES_256_CBC_SHA");
        mapCipherSuite(0x00, 0x92 , "TLS_RSA_PSK_WITH_RC4_128_SHA");
        mapCipherSuite(0x00, 0x93 , "TLS_RSA_PSK_WITH_3DES_EDE_CBC_SHA");
        mapCipherSuite(0x00, 0x94 , "TLS_RSA_PSK_WITH_AES_128_CBC_SHA");
        mapCipherSuite(0x00, 0x95 , "TLS_RSA_PSK_WITH_AES_256_CBC_SHA");
        mapCipherSuite(0x00, 0x96 , "TLS_RSA_WITH_SEED_CBC_SHA");
        mapCipherSuite(0x00, 0x97 , "TLS_DH_DSS_WITH_SEED_CBC_SHA");
        mapCipherSuite(0x00, 0x98 , "TLS_DH_RSA_WITH_SEED_CBC_SHA");
        mapCipherSuite(0x00, 0x99 , "TLS_DHE_DSS_WITH_SEED_CBC_SHA");
        mapCipherSuite(0x00, 0x9A , "TLS_DHE_RSA_WITH_SEED_CBC_SHA");
        mapCipherSuite(0x00, 0x9B , "TLS_DH_anon_WITH_SEED_CBC_SHA");
        mapCipherSuite(0x00, 0x9C , "TLS_RSA_WITH_AES_128_GCM_SHA256");
        mapCipherSuite(0x00, 0x9D , "TLS_RSA_WITH_AES_256_GCM_SHA384");
        mapCipherSuite(0x00, 0x9E , "TLS_DHE_RSA_WITH_AES_128_GCM_SHA256");
        mapCipherSuite(0x00, 0x9F , "TLS_DHE_RSA_WITH_AES_256_GCM_SHA384");
        mapCipherSuite(0x00, 0xA0 , "TLS_DH_RSA_WITH_AES_128_GCM_SHA256");
        mapCipherSuite(0x00, 0xA1 , "TLS_DH_RSA_WITH_AES_256_GCM_SHA384");
        mapCipherSuite(0x00, 0xA2 , "TLS_DHE_DSS_WITH_AES_128_GCM_SHA256");
        mapCipherSuite(0x00, 0xA3 , "TLS_DHE_DSS_WITH_AES_256_GCM_SHA384");
        mapCipherSuite(0x00, 0xA4 , "TLS_DH_DSS_WITH_AES_128_GCM_SHA256");
        mapCipherSuite(0x00, 0xA5 , "TLS_DH_DSS_WITH_AES_256_GCM_SHA384");
        mapCipherSuite(0x00, 0xA6 , "TLS_DH_anon_WITH_AES_128_GCM_SHA256");
        mapCipherSuite(0x00, 0xA7 , "TLS_DH_anon_WITH_AES_256_GCM_SHA384");
        mapCipherSuite(0x00, 0xA8 , "TLS_PSK_WITH_AES_128_GCM_SHA256");
        mapCipherSuite(0x00, 0xA9 , "TLS_PSK_WITH_AES_256_GCM_SHA384");
        mapCipherSuite(0x00, 0xAA , "TLS_DHE_PSK_WITH_AES_128_GCM_SHA256");
        mapCipherSuite(0x00, 0xAB , "TLS_DHE_PSK_WITH_AES_256_GCM_SHA384");
        mapCipherSuite(0x00, 0xAC , "TLS_RSA_PSK_WITH_AES_128_GCM_SHA256");
        mapCipherSuite(0x00, 0xAD , "TLS_RSA_PSK_WITH_AES_256_GCM_SHA384");
        mapCipherSuite(0x00, 0xAE , "TLS_PSK_WITH_AES_128_CBC_SHA256");
        mapCipherSuite(0x00, 0xAF , "TLS_PSK_WITH_AES_256_CBC_SHA384");
        mapCipherSuite(0x00, 0xB0 , "TLS_PSK_WITH_NULL_SHA256");
        mapCipherSuite(0x00, 0xB1 , "TLS_PSK_WITH_NULL_SHA384");
        mapCipherSuite(0x00, 0xB2 , "TLS_DHE_PSK_WITH_AES_128_CBC_SHA256");
        mapCipherSuite(0x00, 0xB3 , "TLS_DHE_PSK_WITH_AES_256_CBC_SHA384");
        mapCipherSuite(0x00, 0xB4 , "TLS_DHE_PSK_WITH_NULL_SHA256");
        mapCipherSuite(0x00, 0xB5 , "TLS_DHE_PSK_WITH_NULL_SHA384");
        mapCipherSuite(0x00, 0xB6 , "TLS_RSA_PSK_WITH_AES_128_CBC_SHA256");
        mapCipherSuite(0x00, 0xB7 , "TLS_RSA_PSK_WITH_AES_256_CBC_SHA384");
        mapCipherSuite(0x00, 0xB8 , "TLS_RSA_PSK_WITH_NULL_SHA256");
        mapCipherSuite(0x00, 0xB9 , "TLS_RSA_PSK_WITH_NULL_SHA384");
        mapCipherSuite(0x00, 0xBA , "TLS_RSA_WITH_CAMELLIA_128_CBC_SHA256");
        mapCipherSuite(0x00, 0xBB , "TLS_DH_DSS_WITH_CAMELLIA_128_CBC_SHA256");
        mapCipherSuite(0x00, 0xBC , "TLS_DH_RSA_WITH_CAMELLIA_128_CBC_SHA256");
        mapCipherSuite(0x00, 0xBD , "TLS_DHE_DSS_WITH_CAMELLIA_128_CBC_SHA256");
        mapCipherSuite(0x00, 0xBE , "TLS_DHE_RSA_WITH_CAMELLIA_128_CBC_SHA256");
        mapCipherSuite(0x00, 0xBF , "TLS_DH_anon_WITH_CAMELLIA_128_CBC_SHA256");
        mapCipherSuite(0x00, 0xC0 , "TLS_RSA_WITH_CAMELLIA_256_CBC_SHA256");
        mapCipherSuite(0x00, 0xC1 , "TLS_DH_DSS_WITH_CAMELLIA_256_CBC_SHA256");
        mapCipherSuite(0x00, 0xC2 , "TLS_DH_RSA_WITH_CAMELLIA_256_CBC_SHA256");
        mapCipherSuite(0x00, 0xC3 , "TLS_DHE_DSS_WITH_CAMELLIA_256_CBC_SHA256");
        mapCipherSuite(0x00, 0xC4 , "TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA256");
        mapCipherSuite(0x00, 0xC5 , "TLS_DH_anon_WITH_CAMELLIA_256_CBC_SHA256");
        mapCipherSuite(0x00, 0xFF , "TLS_EMPTY_RENEGOTIATION_INFO_SCSV");
        mapCipherSuite(0x56, 0x00 , "TLS_FALLBACK_SCSV");
        mapCipherSuite(0xC0, 0x01 , "TLS_ECDH_ECDSA_WITH_NULL_SHA");
        mapCipherSuite(0xC0, 0x02 , "TLS_ECDH_ECDSA_WITH_RC4_128_SHA");
        mapCipherSuite(0xC0, 0x03 , "TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA");
        mapCipherSuite(0xC0, 0x04 , "TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA");
        mapCipherSuite(0xC0, 0x05 , "TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA");
        mapCipherSuite(0xC0, 0x06 , "TLS_ECDHE_ECDSA_WITH_NULL_SHA");
        mapCipherSuite(0xC0, 0x07 , "TLS_ECDHE_ECDSA_WITH_RC4_128_SHA");
        mapCipherSuite(0xC0, 0x08 , "TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA");
        mapCipherSuite(0xC0, 0x09 , "TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA");
        mapCipherSuite(0xC0, 0x0A , "TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA");
        mapCipherSuite(0xC0, 0x0B , "TLS_ECDH_RSA_WITH_NULL_SHA");
        mapCipherSuite(0xC0, 0x0C , "TLS_ECDH_RSA_WITH_RC4_128_SHA");
        mapCipherSuite(0xC0, 0x0D , "TLS_ECDH_RSA_WITH_3DES_EDE_CBC_SHA");
        mapCipherSuite(0xC0, 0x0E , "TLS_ECDH_RSA_WITH_AES_128_CBC_SHA");
        mapCipherSuite(0xC0, 0x0F , "TLS_ECDH_RSA_WITH_AES_256_CBC_SHA");
        mapCipherSuite(0xC0, 0x10 , "TLS_ECDHE_RSA_WITH_NULL_SHA");
        mapCipherSuite(0xC0, 0x11 , "TLS_ECDHE_RSA_WITH_RC4_128_SHA");
        mapCipherSuite(0xC0, 0x12 , "TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA");
        mapCipherSuite(0xC0, 0x13 , "TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA");
        mapCipherSuite(0xC0, 0x14 , "TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA");
        mapCipherSuite(0xC0, 0x15 , "TLS_ECDH_anon_WITH_NULL_SHA");
        mapCipherSuite(0xC0, 0x16 , "TLS_ECDH_anon_WITH_RC4_128_SHA");
        mapCipherSuite(0xC0, 0x17 , "TLS_ECDH_anon_WITH_3DES_EDE_CBC_SHA");
        mapCipherSuite(0xC0, 0x18 , "TLS_ECDH_anon_WITH_AES_128_CBC_SHA");
        mapCipherSuite(0xC0, 0x19 , "TLS_ECDH_anon_WITH_AES_256_CBC_SHA");
        mapCipherSuite(0xC0, 0x1A , "TLS_SRP_SHA_WITH_3DES_EDE_CBC_SHA");
        mapCipherSuite(0xC0, 0x1B , "TLS_SRP_SHA_RSA_WITH_3DES_EDE_CBC_SHA");
        mapCipherSuite(0xC0, 0x1C , "TLS_SRP_SHA_DSS_WITH_3DES_EDE_CBC_SHA");
        mapCipherSuite(0xC0, 0x1D , "TLS_SRP_SHA_WITH_AES_128_CBC_SHA");
        mapCipherSuite(0xC0, 0x1E , "TLS_SRP_SHA_RSA_WITH_AES_128_CBC_SHA");
        mapCipherSuite(0xC0, 0x1F , "TLS_SRP_SHA_DSS_WITH_AES_128_CBC_SHA");
        mapCipherSuite(0xC0, 0x20 , "TLS_SRP_SHA_WITH_AES_256_CBC_SHA");
        mapCipherSuite(0xC0, 0x21 , "TLS_SRP_SHA_RSA_WITH_AES_256_CBC_SHA");
        mapCipherSuite(0xC0, 0x22 , "TLS_SRP_SHA_DSS_WITH_AES_256_CBC_SHA");
        mapCipherSuite(0xC0, 0x23 , "TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256");
        mapCipherSuite(0xC0, 0x24 , "TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384");
        mapCipherSuite(0xC0, 0x25 , "TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA256");
        mapCipherSuite(0xC0, 0x26 , "TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA384");
        mapCipherSuite(0xC0, 0x27 , "TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256");
        mapCipherSuite(0xC0, 0x28 , "TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384");
        mapCipherSuite(0xC0, 0x29 , "TLS_ECDH_RSA_WITH_AES_128_CBC_SHA256");
        mapCipherSuite(0xC0, 0x2A , "TLS_ECDH_RSA_WITH_AES_256_CBC_SHA384");
        mapCipherSuite(0xC0, 0x2B , "TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256");
        mapCipherSuite(0xC0, 0x2C , "TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384");
        mapCipherSuite(0xC0, 0x2D , "TLS_ECDH_ECDSA_WITH_AES_128_GCM_SHA256");
        mapCipherSuite(0xC0, 0x2E , "TLS_ECDH_ECDSA_WITH_AES_256_GCM_SHA384");
        mapCipherSuite(0xC0, 0x2F , "TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256");
        mapCipherSuite(0xC0, 0x30 , "TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384");
        mapCipherSuite(0xC0, 0x31 , "TLS_ECDH_RSA_WITH_AES_128_GCM_SHA256");
        mapCipherSuite(0xC0, 0x32 , "TLS_ECDH_RSA_WITH_AES_256_GCM_SHA384");
        mapCipherSuite(0xC0, 0x33 , "TLS_ECDHE_PSK_WITH_RC4_128_SHA");
        mapCipherSuite(0xC0, 0x34 , "TLS_ECDHE_PSK_WITH_3DES_EDE_CBC_SHA");
        mapCipherSuite(0xC0, 0x35 , "TLS_ECDHE_PSK_WITH_AES_128_CBC_SHA");
        mapCipherSuite(0xC0, 0x36 , "TLS_ECDHE_PSK_WITH_AES_256_CBC_SHA");
        mapCipherSuite(0xC0, 0x37 , "TLS_ECDHE_PSK_WITH_AES_128_CBC_SHA256");
        mapCipherSuite(0xC0, 0x38 , "TLS_ECDHE_PSK_WITH_AES_256_CBC_SHA384");
        mapCipherSuite(0xC0, 0x39 , "TLS_ECDHE_PSK_WITH_NULL_SHA");
        mapCipherSuite(0xC0, 0x3A , "TLS_ECDHE_PSK_WITH_NULL_SHA256");
        mapCipherSuite(0xC0, 0x3B , "TLS_ECDHE_PSK_WITH_NULL_SHA384");
        mapCipherSuite(0xC0, 0x3C , "TLS_RSA_WITH_ARIA_128_CBC_SHA256");
        mapCipherSuite(0xC0, 0x3D , "TLS_RSA_WITH_ARIA_256_CBC_SHA384");
        mapCipherSuite(0xC0, 0x3E , "TLS_DH_DSS_WITH_ARIA_128_CBC_SHA256");
        mapCipherSuite(0xC0, 0x3F , "TLS_DH_DSS_WITH_ARIA_256_CBC_SHA384");
        mapCipherSuite(0xC0, 0x40 , "TLS_DH_RSA_WITH_ARIA_128_CBC_SHA256");
        mapCipherSuite(0xC0, 0x41 , "TLS_DH_RSA_WITH_ARIA_256_CBC_SHA384");
        mapCipherSuite(0xC0, 0x42 , "TLS_DHE_DSS_WITH_ARIA_128_CBC_SHA256");
        mapCipherSuite(0xC0, 0x43 , "TLS_DHE_DSS_WITH_ARIA_256_CBC_SHA384");
        mapCipherSuite(0xC0, 0x44 , "TLS_DHE_RSA_WITH_ARIA_128_CBC_SHA256");
        mapCipherSuite(0xC0, 0x45 , "TLS_DHE_RSA_WITH_ARIA_256_CBC_SHA384");
        mapCipherSuite(0xC0, 0x46 , "TLS_DH_anon_WITH_ARIA_128_CBC_SHA256");
        mapCipherSuite(0xC0, 0x47 , "TLS_DH_anon_WITH_ARIA_256_CBC_SHA384");
        mapCipherSuite(0xC0, 0x48 , "TLS_ECDHE_ECDSA_WITH_ARIA_128_CBC_SHA256");
        mapCipherSuite(0xC0, 0x49 , "TLS_ECDHE_ECDSA_WITH_ARIA_256_CBC_SHA384");
        mapCipherSuite(0xC0, 0x4A , "TLS_ECDH_ECDSA_WITH_ARIA_128_CBC_SHA256");
        mapCipherSuite(0xC0, 0x4B , "TLS_ECDH_ECDSA_WITH_ARIA_256_CBC_SHA384");
        mapCipherSuite(0xC0, 0x4C , "TLS_ECDHE_RSA_WITH_ARIA_128_CBC_SHA256");
        mapCipherSuite(0xC0, 0x4D , "TLS_ECDHE_RSA_WITH_ARIA_256_CBC_SHA384");
        mapCipherSuite(0xC0, 0x4E , "TLS_ECDH_RSA_WITH_ARIA_128_CBC_SHA256");
        mapCipherSuite(0xC0, 0x4F , "TLS_ECDH_RSA_WITH_ARIA_256_CBC_SHA384");
        mapCipherSuite(0xC0, 0x50 , "TLS_RSA_WITH_ARIA_128_GCM_SHA256");
        mapCipherSuite(0xC0, 0x51 , "TLS_RSA_WITH_ARIA_256_GCM_SHA384");
        mapCipherSuite(0xC0, 0x52 , "TLS_DHE_RSA_WITH_ARIA_128_GCM_SHA256");
        mapCipherSuite(0xC0, 0x53 , "TLS_DHE_RSA_WITH_ARIA_256_GCM_SHA384");
        mapCipherSuite(0xC0, 0x54 , "TLS_DH_RSA_WITH_ARIA_128_GCM_SHA256");
        mapCipherSuite(0xC0, 0x55 , "TLS_DH_RSA_WITH_ARIA_256_GCM_SHA384");
        mapCipherSuite(0xC0, 0x56 , "TLS_DHE_DSS_WITH_ARIA_128_GCM_SHA256");
        mapCipherSuite(0xC0, 0x57 , "TLS_DHE_DSS_WITH_ARIA_256_GCM_SHA384");
        mapCipherSuite(0xC0, 0x58 , "TLS_DH_DSS_WITH_ARIA_128_GCM_SHA256");
        mapCipherSuite(0xC0, 0x59 , "TLS_DH_DSS_WITH_ARIA_256_GCM_SHA384");
        mapCipherSuite(0xC0, 0x5A , "TLS_DH_anon_WITH_ARIA_128_GCM_SHA256");
        mapCipherSuite(0xC0, 0x5B , "TLS_DH_anon_WITH_ARIA_256_GCM_SHA384");
        mapCipherSuite(0xC0, 0x5C , "TLS_ECDHE_ECDSA_WITH_ARIA_128_GCM_SHA256");
        mapCipherSuite(0xC0, 0x5D , "TLS_ECDHE_ECDSA_WITH_ARIA_256_GCM_SHA384");
        mapCipherSuite(0xC0, 0x5E , "TLS_ECDH_ECDSA_WITH_ARIA_128_GCM_SHA256");
        mapCipherSuite(0xC0, 0x5F , "TLS_ECDH_ECDSA_WITH_ARIA_256_GCM_SHA384");
        mapCipherSuite(0xC0, 0x60 , "TLS_ECDHE_RSA_WITH_ARIA_128_GCM_SHA256");
        mapCipherSuite(0xC0, 0x61 , "TLS_ECDHE_RSA_WITH_ARIA_256_GCM_SHA384");
        mapCipherSuite(0xC0, 0x62 , "TLS_ECDH_RSA_WITH_ARIA_128_GCM_SHA256");
        mapCipherSuite(0xC0, 0x63 , "TLS_ECDH_RSA_WITH_ARIA_256_GCM_SHA384");
        mapCipherSuite(0xC0, 0x64 , "TLS_PSK_WITH_ARIA_128_CBC_SHA256");
        mapCipherSuite(0xC0, 0x65 , "TLS_PSK_WITH_ARIA_256_CBC_SHA384");
        mapCipherSuite(0xC0, 0x66 , "TLS_DHE_PSK_WITH_ARIA_128_CBC_SHA256");
        mapCipherSuite(0xC0, 0x67 , "TLS_DHE_PSK_WITH_ARIA_256_CBC_SHA384");
        mapCipherSuite(0xC0, 0x68 , "TLS_RSA_PSK_WITH_ARIA_128_CBC_SHA256");
        mapCipherSuite(0xC0, 0x69 , "TLS_RSA_PSK_WITH_ARIA_256_CBC_SHA384");
        mapCipherSuite(0xC0, 0x6A , "TLS_PSK_WITH_ARIA_128_GCM_SHA256");
        mapCipherSuite(0xC0, 0x6B , "TLS_PSK_WITH_ARIA_256_GCM_SHA384");
        mapCipherSuite(0xC0, 0x6C , "TLS_DHE_PSK_WITH_ARIA_128_GCM_SHA256");
        mapCipherSuite(0xC0, 0x6D , "TLS_DHE_PSK_WITH_ARIA_256_GCM_SHA384");
        mapCipherSuite(0xC0, 0x6E , "TLS_RSA_PSK_WITH_ARIA_128_GCM_SHA256");
        mapCipherSuite(0xC0, 0x6F , "TLS_RSA_PSK_WITH_ARIA_256_GCM_SHA384");
        mapCipherSuite(0xC0, 0x70 , "TLS_ECDHE_PSK_WITH_ARIA_128_CBC_SHA256");
        mapCipherSuite(0xC0, 0x71 , "TLS_ECDHE_PSK_WITH_ARIA_256_CBC_SHA384");
        mapCipherSuite(0xC0, 0x72 , "TLS_ECDHE_ECDSA_WITH_CAMELLIA_128_CBC_SHA256");
        mapCipherSuite(0xC0, 0x73 , "TLS_ECDHE_ECDSA_WITH_CAMELLIA_256_CBC_SHA384");
        mapCipherSuite(0xC0, 0x74 , "TLS_ECDH_ECDSA_WITH_CAMELLIA_128_CBC_SHA256");
        mapCipherSuite(0xC0, 0x75 , "TLS_ECDH_ECDSA_WITH_CAMELLIA_256_CBC_SHA384");
        mapCipherSuite(0xC0, 0x76 , "TLS_ECDHE_RSA_WITH_CAMELLIA_128_CBC_SHA256");
        mapCipherSuite(0xC0, 0x77 , "TLS_ECDHE_RSA_WITH_CAMELLIA_256_CBC_SHA384");
        mapCipherSuite(0xC0, 0x78 , "TLS_ECDH_RSA_WITH_CAMELLIA_128_CBC_SHA256");
        mapCipherSuite(0xC0, 0x79 , "TLS_ECDH_RSA_WITH_CAMELLIA_256_CBC_SHA384");
        mapCipherSuite(0xC0, 0x7A , "TLS_RSA_WITH_CAMELLIA_128_GCM_SHA256");
        mapCipherSuite(0xC0, 0x7B , "TLS_RSA_WITH_CAMELLIA_256_GCM_SHA384");
        mapCipherSuite(0xC0, 0x7C , "TLS_DHE_RSA_WITH_CAMELLIA_128_GCM_SHA256");
        mapCipherSuite(0xC0, 0x7D , "TLS_DHE_RSA_WITH_CAMELLIA_256_GCM_SHA384");
        mapCipherSuite(0xC0, 0x7E , "TLS_DH_RSA_WITH_CAMELLIA_128_GCM_SHA256");
        mapCipherSuite(0xC0, 0x7F , "TLS_DH_RSA_WITH_CAMELLIA_256_GCM_SHA384");
        mapCipherSuite(0xC0, 0x80 , "TLS_DHE_DSS_WITH_CAMELLIA_128_GCM_SHA256");
        mapCipherSuite(0xC0, 0x81 , "TLS_DHE_DSS_WITH_CAMELLIA_256_GCM_SHA384");
        mapCipherSuite(0xC0, 0x82 , "TLS_DH_DSS_WITH_CAMELLIA_128_GCM_SHA256");
        mapCipherSuite(0xC0, 0x83 , "TLS_DH_DSS_WITH_CAMELLIA_256_GCM_SHA384");
        mapCipherSuite(0xC0, 0x84 , "TLS_DH_anon_WITH_CAMELLIA_128_GCM_SHA256");
        mapCipherSuite(0xC0, 0x85 , "TLS_DH_anon_WITH_CAMELLIA_256_GCM_SHA384");
        mapCipherSuite(0xC0, 0x86 , "TLS_ECDHE_ECDSA_WITH_CAMELLIA_128_GCM_SHA256");
        mapCipherSuite(0xC0, 0x87 , "TLS_ECDHE_ECDSA_WITH_CAMELLIA_256_GCM_SHA384");
        mapCipherSuite(0xC0, 0x88 , "TLS_ECDH_ECDSA_WITH_CAMELLIA_128_GCM_SHA256");
        mapCipherSuite(0xC0, 0x89 , "TLS_ECDH_ECDSA_WITH_CAMELLIA_256_GCM_SHA384");
        mapCipherSuite(0xC0, 0x8A , "TLS_ECDHE_RSA_WITH_CAMELLIA_128_GCM_SHA256");
        mapCipherSuite(0xC0, 0x8B , "TLS_ECDHE_RSA_WITH_CAMELLIA_256_GCM_SHA384");
        mapCipherSuite(0xC0, 0x8C , "TLS_ECDH_RSA_WITH_CAMELLIA_128_GCM_SHA256");
        mapCipherSuite(0xC0, 0x8D , "TLS_ECDH_RSA_WITH_CAMELLIA_256_GCM_SHA384");
        mapCipherSuite(0xC0, 0x8E , "TLS_PSK_WITH_CAMELLIA_128_GCM_SHA256");
        mapCipherSuite(0xC0, 0x8F , "TLS_PSK_WITH_CAMELLIA_256_GCM_SHA384");
        mapCipherSuite(0xC0, 0x90 , "TLS_DHE_PSK_WITH_CAMELLIA_128_GCM_SHA256");
        mapCipherSuite(0xC0, 0x91 , "TLS_DHE_PSK_WITH_CAMELLIA_256_GCM_SHA384");
        mapCipherSuite(0xC0, 0x92 , "TLS_RSA_PSK_WITH_CAMELLIA_128_GCM_SHA256");
        mapCipherSuite(0xC0, 0x93 , "TLS_RSA_PSK_WITH_CAMELLIA_256_GCM_SHA384");
        mapCipherSuite(0xC0, 0x94 , "TLS_PSK_WITH_CAMELLIA_128_CBC_SHA256");
        mapCipherSuite(0xC0, 0x95 , "TLS_PSK_WITH_CAMELLIA_256_CBC_SHA384");
        mapCipherSuite(0xC0, 0x96 , "TLS_DHE_PSK_WITH_CAMELLIA_128_CBC_SHA256");
        mapCipherSuite(0xC0, 0x97 , "TLS_DHE_PSK_WITH_CAMELLIA_256_CBC_SHA384");
        mapCipherSuite(0xC0, 0x98 , "TLS_RSA_PSK_WITH_CAMELLIA_128_CBC_SHA256");
        mapCipherSuite(0xC0, 0x99 , "TLS_RSA_PSK_WITH_CAMELLIA_256_CBC_SHA384");
        mapCipherSuite(0xC0, 0x9A , "TLS_ECDHE_PSK_WITH_CAMELLIA_128_CBC_SHA256");
        mapCipherSuite(0xC0, 0x9B , "TLS_ECDHE_PSK_WITH_CAMELLIA_256_CBC_SHA384");
        mapCipherSuite(0xC0, 0x9C , "TLS_RSA_WITH_AES_128_CCM");
        mapCipherSuite(0xC0, 0x9D , "TLS_RSA_WITH_AES_256_CCM");
        mapCipherSuite(0xC0, 0x9E , "TLS_DHE_RSA_WITH_AES_128_CCM");
        mapCipherSuite(0xC0, 0x9F , "TLS_DHE_RSA_WITH_AES_256_CCM");
        mapCipherSuite(0xC0, 0xA0 , "TLS_RSA_WITH_AES_128_CCM_8");
        mapCipherSuite(0xC0, 0xA1 , "TLS_RSA_WITH_AES_256_CCM_8");
        mapCipherSuite(0xC0, 0xA2 , "TLS_DHE_RSA_WITH_AES_128_CCM_8");
        mapCipherSuite(0xC0, 0xA3 , "TLS_DHE_RSA_WITH_AES_256_CCM_8");
        mapCipherSuite(0xC0, 0xA4 , "TLS_PSK_WITH_AES_128_CCM");
        mapCipherSuite(0xC0, 0xA5 , "TLS_PSK_WITH_AES_256_CCM");
        mapCipherSuite(0xC0, 0xA6 , "TLS_DHE_PSK_WITH_AES_128_CCM");
        mapCipherSuite(0xC0, 0xA7 , "TLS_DHE_PSK_WITH_AES_256_CCM");
        mapCipherSuite(0xC0, 0xA8 , "TLS_PSK_WITH_AES_128_CCM_8");
        mapCipherSuite(0xC0, 0xA9 , "TLS_PSK_WITH_AES_256_CCM_8");
        mapCipherSuite(0xC0, 0xAA , "TLS_PSK_DHE_WITH_AES_128_CCM_8");
        mapCipherSuite(0xC0, 0xAB , "TLS_PSK_DHE_WITH_AES_256_CCM_8");
        mapCipherSuite(0xC0, 0xAC , "TLS_ECDHE_ECDSA_WITH_AES_128_CCM");
        mapCipherSuite(0xC0, 0xAD , "TLS_ECDHE_ECDSA_WITH_AES_256_CCM");
        mapCipherSuite(0xC0, 0xAE , "TLS_ECDHE_ECDSA_WITH_AES_128_CCM_8");
        mapCipherSuite(0xC0, 0xAF , "TLS_ECDHE_ECDSA_WITH_AES_256_CCM_8");
        mapCipherSuite(0xCC, 0xA8 , "TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256");
        mapCipherSuite(0xCC, 0xA9 , "TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256");
        mapCipherSuite(0xCC, 0xAA , "TLS_DHE_RSA_WITH_CHACHA20_POLY1305_SHA256");
        mapCipherSuite(0xCC, 0xAB , "TLS_PSK_WITH_CHACHA20_POLY1305_SHA256");
        mapCipherSuite(0xCC, 0xAC , "TLS_ECDHE_PSK_WITH_CHACHA20_POLY1305_SHA256");
        mapCipherSuite(0xCC, 0xAD , "TLS_DHE_PSK_WITH_CHACHA20_POLY1305_SHA256");
        mapCipherSuite(0xCC, 0xAE , "TLS_RSA_PSK_WITH_CHACHA20_POLY1305_SHA256");
    }

    private static void mapCipherSuite(int code1, int code2, String cipherName)
    {
        int code = (code1 << 8) + code2;
        names.put(code, cipherName);
    }

    private CipherSuiteName()
    {
    }
}