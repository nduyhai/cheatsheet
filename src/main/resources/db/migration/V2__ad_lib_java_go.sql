insert into cheat_sheet(language_id, category_id, title, description, url)
values ((select id
         from language
         where name = 'Java'), (select id
                                from category
                                where name = 'Monitoring'), 'Spectator',
        'Client library for collecting metrics.',
        'https://github.com/Netflix/spectator'),
       ((select id
         from language
         where name = 'Java'), (select id
                                from category
                                where name = 'Gateway'), 'Apache ShenYu',
        'Apache ShenYu is a Java native API Gateway for service proxy, protocol conversion and API governance.',
        'https://github.com/apache/shenyu'),
       ((select id
         from language
         where name = 'Go'), (select id
                              from category
                              where name = 'Database'), 'TiDB',
        'TiDB is an open-source, cloud-native, distributed, MySQL-Compatible database for elastic scale and real-time analytics',
        'https://github.com/pingcap/tidb'),
       ((select id
         from language
         where name = 'Go'), (select id
                              from category
                              where name = 'API docs'), 'Swag ',
        'Automatically generate RESTful API documentation with Swagger 2.0 for Go.',
        'https://github.com/swaggo/swag'),
       ((select id
         from language
         where name = 'Go'), (select id
                              from category
                              where name = 'API docs'), 'oapi-codegen ',
        'Generate Go client and server boilerplate from OpenAPI 3 specifications',
        'https://github.com/oapi-codegen/oapi-codegen'),
       ((select id
         from language
         where name = 'Go'), (select id
                              from category
                              where name = 'Configuration'), 'envconfig ',
        'Golang library for managing configuration data from environment variables',
        'https://github.com/kelseyhightower/envconfig'),
       ((select id
         from language
         where name = 'Go'), (select id
                              from category
                              where name = 'Dependency Injection'), 'Wire',
        'Compile-time Dependency Injection for Go',
        'https://github.com/google/wire'),
       ((select id
         from language
         where name = 'Go'), (select id
                              from category
                              where name = 'Dependency Injection'), 'IOC-golang',
        'A Golang depenedency injection framework, helps developers to build any go application',
        'https://github.com/alibaba/IOC-golang'),
       ((select id
         from language
         where name = 'Go'), (select id
                              from category
                              where name = 'Testing'), 'Testify',
        'A toolkit with common assertions and mocks that plays nicely with the standard library',
        'https://github.com/stretchr/testify'),
       ((select id
         from language
         where name = 'Go'), (select id
                              from category
                              where name = 'Testing'), 'moq',
        'Interface mocking tool for go generate',
        'https://github.com/matryer/moq'),
       ((select id
         from language
         where name = 'Go'), (select id
                              from category
                              where name = 'Testing'), 'gomock',
        'GoMock is a mocking framework for the Go programming language',
        'https://github.com/uber-go/mock'),
       ((select id
         from language
         where name = 'Go'), (select id
                              from category
                              where name = 'Linter'), 'golangci-lint', 'Fast linters runner for Go',
        'https://github.com/golangci/golangci-lint'),
       ((select id
         from language
         where name = 'Go'), (select id
                              from category
                              where name = 'Messaging'), 'NSQ',
        'A realtime distributed messaging platform',
        'https://github.com/nsqio/nsq');