# Changelog

## 0.1.0-alpha.1 (2026-05-13)

Full Changelog: [v0.0.1-alpha.0...v0.1.0-alpha.1](https://github.com/vern-so/sdk-java/compare/v0.0.1-alpha.0...v0.1.0-alpha.1)

### Features

* add retryable exception ([6e920ad](https://github.com/vern-so/sdk-java/commit/6e920addfbc79e00663f0088a6075f05ef7bafb9))
* **api:** api update ([8543c16](https://github.com/vern-so/sdk-java/commit/8543c1640eb8437cfe8eea4f9f3138357a3ed39a))
* **api:** api update ([bb127c2](https://github.com/vern-so/sdk-java/commit/bb127c2658fe0852080a20f25ad8628abf33451b))
* **api:** api update ([e62c881](https://github.com/vern-so/sdk-java/commit/e62c8816199bae23c83686b848311c8f969c8d85))
* **api:** api update ([a04f07a](https://github.com/vern-so/sdk-java/commit/a04f07aab5d6b759ad84f60e21ab7a0f2e58dbaf))
* **api:** api update ([a3098e3](https://github.com/vern-so/sdk-java/commit/a3098e36e3151fb19b9bb89b72f69e38d1a7129a))
* **api:** api update ([1463884](https://github.com/vern-so/sdk-java/commit/1463884d2ca146ee0a47139ae783a9a01e3cf234))
* **api:** api update ([12a6fd2](https://github.com/vern-so/sdk-java/commit/12a6fd278f3b7902e4c26a749ce981eb08c43936))
* **api:** api update ([f92432c](https://github.com/vern-so/sdk-java/commit/f92432caf5cfb25e2f4e5853a63be61120fbafe5))
* **api:** api update ([acb30f8](https://github.com/vern-so/sdk-java/commit/acb30f84dd8319da6a77ceb6376c53bb645b3002))
* **api:** api update ([e3cb6bd](https://github.com/vern-so/sdk-java/commit/e3cb6bd34a363e4fe61363ce02e067f2c0a55576))
* **api:** api update ([6ff388a](https://github.com/vern-so/sdk-java/commit/6ff388a0d961dd1258d542c6d197a547e150ded7))
* **api:** api update ([57e7699](https://github.com/vern-so/sdk-java/commit/57e76997a395fd0109b0a11ad25f38e4fe8000df))
* **api:** api update ([24251c7](https://github.com/vern-so/sdk-java/commit/24251c74fd2930546bcb18a66e7ad29c537cff30))
* **api:** api update ([5671d96](https://github.com/vern-so/sdk-java/commit/5671d9687cc272decc7c871bc601cf22213c4cca))
* **api:** api update ([07a2dd3](https://github.com/vern-so/sdk-java/commit/07a2dd3d394183496bc16e1726ec8ac78af3931d))
* **api:** api update ([2fc56dc](https://github.com/vern-so/sdk-java/commit/2fc56dc770794175a31df25146a0ab36e6439eb5))
* **api:** api update ([5f44619](https://github.com/vern-so/sdk-java/commit/5f4461975686311294f8d2f448258132debd1c13))
* **client:** add `{QueryParams,Headers}#put(String, JsonValue)` methods ([162f532](https://github.com/vern-so/sdk-java/commit/162f5328c4afb609fd43fbd635c7173425c62c1e))
* **client:** add a `withOptions` method ([18c3f93](https://github.com/vern-so/sdk-java/commit/18c3f934ce480edba72667216b4f5cc7daa7f1fd))
* **client:** add https config options ([0b4e938](https://github.com/vern-so/sdk-java/commit/0b4e9381ed788546b600c459bf1ae55c84a41c51))
* **client:** allow configuring env via system properties ([7e473ba](https://github.com/vern-so/sdk-java/commit/7e473ba040f995bdf1d08d15080df4fed73136e5))
* **client:** ensure compat with proguard ([a3b8b56](https://github.com/vern-so/sdk-java/commit/a3b8b568613f972bb98baa88944b5b9644bef576))
* **client:** implement per-endpoint base URL support ([f31d46d](https://github.com/vern-so/sdk-java/commit/f31d46db14d5ece849c55409017600e5aba9aea1))
* **client:** improve logging ([f7ceacb](https://github.com/vern-so/sdk-java/commit/f7ceacb56735fcea19cb15c7bf77e838f9a5d2b9))


### Bug Fixes

* **ci:** release-doctor — report correct token name ([92a3710](https://github.com/vern-so/sdk-java/commit/92a3710060cb64e535213cec8520d72fe6a2d8d6))
* **client:** bump max requests per host to max requests (5 -&gt; 64) ([7fcd3ed](https://github.com/vern-so/sdk-java/commit/7fcd3edfaf94f7ae65e4e822678206d99f32c20d))
* **client:** don't close client on `withOptions` usage when original is gc'd ([9c8ea62](https://github.com/vern-so/sdk-java/commit/9c8ea6220ac175801948f8c01a294284fed9b629))
* **client:** ensure error handling always occurs ([5f34730](https://github.com/vern-so/sdk-java/commit/5f34730014091ef7d996ac46508cfdfcea2ab9f2))
* **client:** r8 support ([091d7e3](https://github.com/vern-so/sdk-java/commit/091d7e38ea39e3a7c4665ffe374cb43a92a34cb7))
* **internal:** set maven publish url ([d42e977](https://github.com/vern-so/sdk-java/commit/d42e97729288b4a8162c6f1292ddeb7a58bdbb77))


### Performance Improvements

* **client:** create one json mapper ([54381aa](https://github.com/vern-so/sdk-java/commit/54381aadcb89adeb1cc9c904d01d70efe1ba06ec))


### Chores

* **ci:** bump `actions/setup-java` to v4 ([aaedae1](https://github.com/vern-so/sdk-java/commit/aaedae1f7e6f44f7a18f77cfc505a1e3e04f1ed8))
* **ci:** enable for pull requests ([2fd8b91](https://github.com/vern-so/sdk-java/commit/2fd8b91dad2f8751f3d07ae8450ae7c7aa778e7e))
* **ci:** only run for pushes and fork pull requests ([0aabe42](https://github.com/vern-so/sdk-java/commit/0aabe429bdd1f25e94c8c8633bf67ae0f1f30bba))
* **internal:** allow running specific example from cli ([209d1b7](https://github.com/vern-so/sdk-java/commit/209d1b7502b9c1ba92ccab4dadb3b92d11b0206d))
* **internal:** bump ci test timeout ([afc6da1](https://github.com/vern-so/sdk-java/commit/afc6da1108f447ba7f2ec44a4f0b769db44a7b19))
* **internal:** codegen related update ([f0f9418](https://github.com/vern-so/sdk-java/commit/f0f94182eba84b6eac32493f7169a4800fb22cf0))
* **internal:** codegen related update ([3e6d247](https://github.com/vern-so/sdk-java/commit/3e6d247dde15a8c8ddfb8e1fa1c8504bc15a3210))
* **internal:** codegen related update ([71eb38a](https://github.com/vern-so/sdk-java/commit/71eb38a7570a29aea25be1e6b940002137d79f36))
* **internal:** codegen related update ([e64be34](https://github.com/vern-so/sdk-java/commit/e64be3407bb8155a508f56c490592d76ffefc1e4))
* **internal:** codegen related update ([a76e828](https://github.com/vern-so/sdk-java/commit/a76e828ea1f3034c712a67af83d62c3b4317b510))
* **internal:** codegen related update ([5177126](https://github.com/vern-so/sdk-java/commit/5177126c80fd392c2b1f48a666272a5dd47a204a))
* **internal:** codegen related update ([4feb5b7](https://github.com/vern-so/sdk-java/commit/4feb5b75ad2206d4846949702783198880da57c3))
* **internal:** codegen related update ([1e45b00](https://github.com/vern-so/sdk-java/commit/1e45b00a86984ea6b16508ed24f1a91cf47e24bb))
* **internal:** codegen related update ([acecc9b](https://github.com/vern-so/sdk-java/commit/acecc9b0db473102c61bdbff0d1d2964a152f8fd))
* **internal:** codegen related update ([e1adbf4](https://github.com/vern-so/sdk-java/commit/e1adbf42465df870dabcd2c7a635978f0b2fc84d))
* **internal:** codegen related update ([e2b5186](https://github.com/vern-so/sdk-java/commit/e2b518668f850eeb6a65212cb0b49bb181dc36b7))
* **internal:** codegen related update ([c00f683](https://github.com/vern-so/sdk-java/commit/c00f68373fd82f26c13b1508fca8d3f511f134bc))
* **internal:** codegen related update ([ff88407](https://github.com/vern-so/sdk-java/commit/ff88407e5dee642c0bd15beae1f13e878443fd0b))
* **internal:** codegen related update ([0692052](https://github.com/vern-so/sdk-java/commit/069205216f6b77d80c265f2c9558aa5bfe23ddb2))
* **internal:** codegen related update ([6effc7b](https://github.com/vern-so/sdk-java/commit/6effc7bc9a15b31202930fc158cf67106f60690b))
* **internal:** codegen related update ([8494c43](https://github.com/vern-so/sdk-java/commit/8494c4330325f08dbb7d0e404d045b34ea94ac9a))
* **internal:** codegen related update ([1e5aefb](https://github.com/vern-so/sdk-java/commit/1e5aefbd77e6abc114a2840713648d95487dc8bf))
* **internal:** codegen related update ([c64dd32](https://github.com/vern-so/sdk-java/commit/c64dd320a3d7d809e9f50f895f1d1be8831b2bd7))
* **internal:** reduce proguard ci logging ([8de3972](https://github.com/vern-so/sdk-java/commit/8de3972693a6fdb76a25e2974b743ef07b017469))
* **internal:** refactor delegating from client to options ([1674ed6](https://github.com/vern-so/sdk-java/commit/1674ed62e56f6548453bd96912a30b46c2e8ff3d))
* **internal:** remove unnecessary `[...]` in `[@see](https://github.com/see)` ([5ae32dc](https://github.com/vern-so/sdk-java/commit/5ae32dcfbc84bc9cedab347326a88e139c7ad798))
* **internal:** unskip some tests ([b686196](https://github.com/vern-so/sdk-java/commit/b68619699dba03f9e8faf9cdbe1bdb83aa8dc1dc))
* update SDK settings ([4813065](https://github.com/vern-so/sdk-java/commit/48130655d947bcb8770ecb83e46238b5bbea341c))
* update SDK settings ([be93968](https://github.com/vern-so/sdk-java/commit/be939680363742a60dc7a99d15c9597a6c035497))


### Documentation

* fix missing readme comment ([4fa0d49](https://github.com/vern-so/sdk-java/commit/4fa0d49f3b57fa1a29269697e0912ad8d56eb77f))
* more code comments ([efef754](https://github.com/vern-so/sdk-java/commit/efef754e0f8f93e5d643984df9e1c7936a514405))


### Refactors

* **internal:** minor `ClientOptionsTest` change ([fdebdee](https://github.com/vern-so/sdk-java/commit/fdebdee65df85c9da21ad30f57fd6f20b12801c2))
